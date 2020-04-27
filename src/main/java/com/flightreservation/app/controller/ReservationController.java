package com.flightreservation.app.controller;

import com.flightreservation.app.dto.RequestData;
import com.flightreservation.app.model.Reservation;
import com.flightreservation.app.repo.FlightRepository;
import com.flightreservation.app.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    private final FlightRepository flightRepository;

    private final ReservationService reservationService;
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    public ReservationController(FlightRepository flightRepository, ReservationService reservationService) {
        this.flightRepository = flightRepository;
        this.reservationService = reservationService;

    }

    //    go to reservation page
    @RequestMapping("/reservationPage")
    public String sayReservation(@RequestParam("id") int id, ModelMap modelMap) {
        logger.info("sayReservation(int flightId) open reservation page");
        var flight = flightRepository.findById(id);
        logger.info("send flight details to reservation page");
        flight.ifPresent(value -> modelMap.addAttribute("flight", value));
        return "/userHome/reservation";
    }

    //    complete reservation
    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String doReservation(RequestData requestData, ModelMap modelMap) {
        Reservation reservation = reservationService.completeReservation(requestData);
        modelMap.addAttribute("msg", "Reservation is successfully : ");
        return "/userHome/reservationMessage";
    }


}
