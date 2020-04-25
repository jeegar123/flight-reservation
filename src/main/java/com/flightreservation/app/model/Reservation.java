package com.flightreservation.app.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reservation")
public class Reservation {
    private int id;
    private int checkedIn;
    private int numberOfBags;
    private int passengerId;
    private int flightId;
    private Timestamp created;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "checked_in", nullable = true)
    public int getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(int checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Basic
    @Column(name = "number_of_bags", nullable = true)
    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    @Basic
    @Column(name = "passenger_id", nullable = false)
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    @Basic
    @Column(name = "flight_id", nullable = true)
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Basic
    @Column(name = "created", nullable = false)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id &&
                checkedIn == that.checkedIn &&
                numberOfBags == that.numberOfBags &&
                passengerId == that.passengerId &&
                flightId == that.flightId &&
                Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkedIn, numberOfBags, passengerId, flightId, created);
    }
}
