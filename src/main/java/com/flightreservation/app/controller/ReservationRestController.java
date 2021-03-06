package com.flightreservation.app.controller;

import com.flightreservation.app.dto.ReservationData;
import com.flightreservation.app.dto.ReservationUpdateRequest;
import com.flightreservation.app.model.Flight;
import com.flightreservation.app.model.Passenger;
import com.flightreservation.app.model.Reservation;
import com.flightreservation.app.repo.FlightRepository;
import com.flightreservation.app.repo.PassengerRepository;
import com.flightreservation.app.repo.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {

    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final ReservationRepository reservationRepository;
    private static final Logger logger = LoggerFactory.getLogger(ReservationRestController.class);

    public ReservationRestController(PassengerRepository passengerRepository, ReservationRepository reservationRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
    }

    @GetMapping("/{id}")
    public ReservationData getReservationDetails(@PathVariable("id") int id) {
        logger.info("getReservation(int reservationId)");
//        get data from database
        logger.info("fetch reservation data");
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

    @PutMapping("/")
    public Reservation getUpdateReservation(@RequestBody ReservationUpdateRequest reservationUpdateRequest) {
        logger.info("getUpdateReservation(ReservationData)");

        logger.info("update reservation data");
        Reservation reservation = reservationRepository.findById(reservationUpdateRequest.getReservationId()).get();
        reservation.setCheckedIn(reservationUpdateRequest.getCheckIn());
        reservation.setNumberOfBags(reservationUpdateRequest.getNumberOfBags());
        reservationRepository.save(reservation);
        return reservation;
    }


}
