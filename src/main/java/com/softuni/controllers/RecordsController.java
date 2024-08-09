package com.softuni.controllers;

import com.softuni.service.ConstructorService;
import com.softuni.service.DriverService;
import com.softuni.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/records")
public class RecordsController extends BaseController {

    private final DriverService driverService;
    private final ConstructorService constructorService;
    private final TrackService trackService;

    @Autowired
    public RecordsController(DriverService driverService, ConstructorService constructorService, TrackService trackService) {
        this.driverService = driverService;
        this.constructorService = constructorService;
        this.trackService = trackService;
    }

    @GetMapping
    public ModelAndView getAllRecords(ModelAndView modelAndView) {

        return super.view("records",
                modelAndView
                        .addObject("driverMostWins", this.driverService.getDriverWithMostWins())
                        .addObject("driverMostPodiums", this.driverService.getDriverWithMostPodiums())
                        .addObject("countryWithMostDrivers", this.driverService.getCountryWithMostDrivers())
                        .addObject("constructorWithMostWins", this.constructorService.getConstructorWithMostWins())
                        .addObject("constructorWithMostTitles", this.constructorService.getConstructorWithMostTitles())
                        .addObject("oldestConstructor", this.constructorService.getOldestConstructor())
                        .addObject("youngestConstructor", this.constructorService.getYoungestConstructor())
                        .addObject("trackWithMostLaps", this.trackService.getTrackWithMostLaps())
                        .addObject("oldestTrack", this.trackService.getOldestTrack())
        );
    }
}
