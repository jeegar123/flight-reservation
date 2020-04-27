package com.flightreservation.app.dto;

public class ReservationUpdateRequest {

    int reservationId;
    int numberOfBags;
    int checkIn;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public int getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }

    @Override
    public String toString() {
        return "ReservationUpdateRequest{" +
                "reservationId=" + reservationId +
                ", numberOfBags=" + numberOfBags +
                ", checkIn=" + checkIn +
                '}';
    }
}
