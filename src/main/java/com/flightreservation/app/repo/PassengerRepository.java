package com.flightreservation.app.repo;

import com.flightreservation.app.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
    Passenger findByEmail(String email);
}
