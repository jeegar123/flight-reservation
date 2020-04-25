package com.flightreservation.app.dto;

import com.flightreservation.app.model.Flight;
import com.flightreservation.app.model.Passenger;
import com.flightreservation.app.model.Reservation;

public class ReservationData {

    Passenger passengerDetails;
    Reservation reservationDetails;
    Flight flightDetails;

    public Passenger getPassengerDetails() {
        return passengerDetails;
    }

    public void setPassengerDetails(Passenger passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    public Reservation getReservationDetails() {
        return reservationDetails;
    }

    public void setReservationDetails(Reservation reservationDetails) {
        this.reservationDetails = reservationDetails;
    }

    public Flight getFlightDetails() {
        return flightDetails;
    }

    public void setFlightDetails(Flight flightDetails) {
        this.flightDetails = flightDetails;
    }
}
