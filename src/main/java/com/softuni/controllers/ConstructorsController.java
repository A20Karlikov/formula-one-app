package com.softuni.controllers;

import com.softuni.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        return this.view("constructors", modelAndView.addObject("constructors", this.constructorService.getAllConstructors()));
    }
}
