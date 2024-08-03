package com.softuni.controllers;

import com.softuni.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/drivers")
public class DriverController extends BaseController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public ModelAndView getAllDrivers(ModelAndView modelAndView) {
        return super.view("drivers", modelAndView.addObject("drivers", this.driverService.getAllDrivers()));
    }
}
