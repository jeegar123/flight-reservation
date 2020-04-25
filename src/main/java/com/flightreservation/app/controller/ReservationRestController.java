package com.flightreservation.app.controller;

import com.flightreservation.app.dto.ReservationData;
import com.flightreservation.app.model.Flight;
import com.flightreservation.app.model.Passenger;
import com.flightreservation.app.model.Reservation;
import com.flightreservation.app.repo.FlightRepository;
import com.flightreservation.app.repo.PassengerRepository;
import com.flightreservation.app.repo.ReservationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {

    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final ReservationRepository reservationRepository;

    public ReservationRestController(PassengerRepository passengerRepository, ReservationRepository reservationRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
    }

    @GetMapping("/{id}")
    public ReservationData getReservationDetails(@PathVariable("id") int id) {
//        get data from database
        Reservation reservationDetails = reservationRepository.findById(id).get();
        Passenger passengerDetails = passengerRepository.findById(reservationDetails.getPassengerId()).get();
        Flight flightDetails = flightRepository.findById(reservationDetails.getFlightId()).get();

//add to ReservationData Class
        ReservationData reservationData = new ReservationData();
        reservationData.setFlightDetails(flightDetails);
        reservationData.setPassengerDetails(passengerDetails);
        reservationData.setReservationDetails(reservationDetails);

        return reservationData;
    }

}
