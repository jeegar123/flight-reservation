package com.flightreservation.app.service;

import com.flightreservation.app.dto.RequestData;
import com.flightreservation.app.dto.ReservationData;
import com.flightreservation.app.model.Flight;
import com.flightreservation.app.model.Passenger;
import com.flightreservation.app.model.Reservation;
import com.flightreservation.app.repo.FlightRepository;
import com.flightreservation.app.repo.PassengerRepository;
import com.flightreservation.app.repo.ReservationRepository;
import com.flightreservation.app.util.EmailSender;
import com.flightreservation.app.util.PDFGenerator;
import org.springframework.stereotype.Service;

@Service

public class ReservationService {

    private final PassengerRepository passengerRepository;
    private final ReservationRepository reservationRepository;
    private final FlightRepository flightRepository;
    final
    PDFGenerator pdfGenerator;
    final
    EmailSender emailSender;

    public ReservationService(PassengerRepository passengerRepository, ReservationRepository reservationRepository, FlightRepository flightRepository, PDFGenerator pdfGenerator, EmailSender emailSender) {
        this.passengerRepository = passengerRepository;
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
        this.pdfGenerator = pdfGenerator;
        this.emailSender = emailSender;
    }

    public Reservation completeReservation(RequestData requestData) {

        Passenger passenger = new Passenger();
        passenger.setEmail(requestData.getEmail());
        passenger.setFirstName(requestData.getFirstName());
        passenger.setLastName(requestData.getLastName());
        passenger.setPhone(requestData.getPhone());

        //        saved passeneger
        passengerRepository.save(passenger);
        Passenger savedPassenger = passengerRepository.findByEmail(passenger.getEmail());
//        Flight

        Flight flight = flightRepository.findById(requestData.getFlightId()).get();
//        saved Reservation
        Reservation reservation = new Reservation();
        reservation.setFlightId(flight.getId());
        reservation.setCheckedIn((byte) 0);
        reservation.setPassengerId(savedPassenger.getId());
        reservationRepository.save(reservation);
        String filePath = "D://" + reservation.getId() + ".pdf";

        ReservationData reservationData = new ReservationData();
        reservationData.setPassengerDetails(passenger);
        reservationData.setFlightDetails(flight);
        reservationData.setReservationDetails(reservation);

        pdfGenerator.generatePdF(reservationData, filePath);
        emailSender.sendEmail(passenger.getEmail(), filePath);
        return reservation;
    }

}
