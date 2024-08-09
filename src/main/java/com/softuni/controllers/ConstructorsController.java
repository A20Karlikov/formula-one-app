package com.softuni.controllers;

import com.softuni.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/constructors")
public class ConstructorsController extends BaseController {

    private final ConstructorService constructorService;

    @Autowired
    public ConstructorsController(ConstructorService constructorService) {
        this.constructorService = constructorService;
    }

    @GetMapping
    public ModelAndView getAllTeams(ModelAndView modelAndView) {
        return super.view("constructors", modelAndView.addObject("constructors", this.constructorService.getAllConstructors()));
    }

    @GetMapping("/{name}")
    public ModelAndView getTeamDetails(@PathVariable String name, ModelAndView modelAndView) {
        return super.view("constructor-details",
                modelAndView
                        .addObject("constructorDetails", this.constructorService.getConstructorByName(name))
                        .addObject("drivers", this.constructorService.getTeamDrivers(name))
        );
    }
}
