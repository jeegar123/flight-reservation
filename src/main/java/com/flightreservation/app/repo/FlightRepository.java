package com.flightreservation.app.repo;

import com.flightreservation.app.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {


    @Query("from Flight WHERE arrivalCity = :to and departureCity = :from and dateOfDepartment = :date")
    List<Flight> findFlights(@Param("to") String arrivalCity, @Param("from") String departureCity, @Param("date") Date dateOfDepartment);
}
