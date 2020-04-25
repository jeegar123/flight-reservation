package com.flightreservation.app.controller;

import com.flightreservation.app.dto.RequestData;
import com.flightreservation.app.model.Reservation;
import com.flightreservation.app.repo.FlightRepository;
import com.flightreservation.app.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    private final FlightRepository flightRepository;

    private final ReservationService reservationService;



    public ReservationController(FlightRepository flightRepository, ReservationService reservationService) {
        this.flightRepository = flightRepository;
        this.reservationService = reservationService;
    }

    @RequestMapping("/reservationPage")
    public String sayReservation(@RequestParam("id") int id, ModelMap modelMap){
        var flight=flightRepository.findById(id);
        flight.ifPresent(value -> modelMap.addAttribute("flight", value));
        return "/userHome/reservation";
    }

    @RequestMapping(value = "/completeReservation",method = RequestMethod.POST)
    public  String  doReservation(RequestData requestData, ModelMap modelMap){
        Reservation reservation=reservationService.completeReservation(requestData);
        modelMap.addAttribute("msg","Reservation is successfully with Id: "+reservation.getId());
        return "/userHome/reservationMessage";
    }



}
