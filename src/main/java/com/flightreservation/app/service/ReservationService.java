package com.flightreservation.app.service;

import com.flightreservation.app.dto.RequestData;
import com.flightreservation.app.model.Flight;
import com.flightreservation.app.model.Passenger;
import com.flightreservation.app.model.Reservation;
import com.flightreservation.app.repo.FlightRepository;
import com.flightreservation.app.repo.PassengerRepository;
import com.flightreservation.app.repo.ReservationRepository;
import org.springframework.stereotype.Service;

@Service

public class ReservationService {

    private final PassengerRepository passengerRepository;
    private final ReservationRepository reservationRepository;
    private final FlightRepository flightRepository;


    public ReservationService(PassengerRepository passengerRepository, ReservationRepository reservationRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
    }

    public Reservation completeReservation(RequestData requestData) {

        Passenger passenger = new Passenger();
        passenger.setEmail(requestData.getEmail());
        passenger.setFirstName(requestData.getFirstName());
        passenger.setLastName(requestData.getLastName());
        passenger.setPhone(requestData.getPhone());

        //        saved passeneger
         passengerRepository.save(passenger);
         Passenger savedPassenger=passengerRepository.findByEmail(passenger.getEmail());
//        Flight

        Flight flight = flightRepository.findById(requestData.getFlightId()).get();
//        saved Reservation
        Reservation reservation = new Reservation();
        reservation.setFlightId(flight.getId());
        reservation.setCheckedIn((byte) 0);
        reservation.setPassengerId(savedPassenger.getId());
        reservationRepository.save(reservation);
        System.out.println("reservation id"+reservation.getPassengerId());

        return reservation;
    }

}
