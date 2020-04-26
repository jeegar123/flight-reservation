package com.flightreservation.app.controller;

import com.flightreservation.app.model.Flight;
import com.flightreservation.app.repo.FlightRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @RequestMapping("/searchFlightPage")
    public String saySearchFlight() {
        return "userHome/searchFlight";
    }

/*
*   search flight from database
* */
    @RequestMapping(value = "/searchFlight", method = RequestMethod.POST)
    public String saySearchedFlights(@RequestParam("arrivalCity") String arrivalCity, @RequestParam("departureCity") String departureCity,
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("dateOfDepartment") Date dateOfDepartment, ModelMap modelMap) {
        List<Flight> flights = flightRepository.findFlights(arrivalCity, departureCity, dateOfDepartment);
        modelMap.addAttribute("flightList", flights);
        return "userHome/searchedFlights";
    }

}
