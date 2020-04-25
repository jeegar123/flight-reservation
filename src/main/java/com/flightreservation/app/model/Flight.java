package com.flightreservation.app.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "flight")
public class Flight {
    private int id;
    private String flightNumber;
    private String operatingAirlines;
    private String arrivalCity;
    private String departureCity;
    private Date dateOfDepartment;
    private Timestamp estimateDepartmentTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "flight_number", nullable = false, length = 20)
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Basic
    @Column(name = "operating_airlines", nullable = false, length = 20)
    public String getOperatingAirlines() {
        return operatingAirlines;
    }

    public void setOperatingAirlines(String operatingAirlines) {
        this.operatingAirlines = operatingAirlines;
    }

    @Basic
    @Column(name = "arrival_city", nullable = false, length = 20)
    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    @Basic
    @Column(name = "departure_city", nullable = false, length = 20)
    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    @Basic
    @Column(name = "date_of_department", nullable = false)
    public Date getDateOfDepartment() {
        return dateOfDepartment;
    }

    public void setDateOfDepartment(Date dateOfDepartment) {
        this.dateOfDepartment = dateOfDepartment;
    }

    @Basic
    @Column(name = "estimate_department_time", nullable = false)
    public Timestamp getEstimateDepartmentTime() {
        return estimateDepartmentTime;
    }

    public void setEstimateDepartmentTime(Timestamp estimateDepartmentTime) {
        this.estimateDepartmentTime = estimateDepartmentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                Objects.equals(flightNumber, flight.flightNumber) &&
                Objects.equals(operatingAirlines, flight.operatingAirlines) &&
                Objects.equals(arrivalCity, flight.arrivalCity) &&
                Objects.equals(departureCity, flight.departureCity) &&
                Objects.equals(dateOfDepartment, flight.dateOfDepartment) &&
                Objects.equals(estimateDepartmentTime, flight.estimateDepartmentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNumber, operatingAirlines, arrivalCity, departureCity, dateOfDepartment, estimateDepartmentTime);
    }
}
