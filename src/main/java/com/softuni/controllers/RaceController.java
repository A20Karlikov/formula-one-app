package com.softuni.controllers;

import com.softuni.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/races")
public class RaceController extends BaseController {

    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/{id}")
    public ModelAndView getAllRaces(@PathVariable Long id, ModelAndView modelAndView) {
        return super.view(
                "races",
                modelAndView
                        .addObject("raceHeaders", this.raceService.getRaceHeaders())
                        .addObject("raceById", this.raceService.getSelectedRace(id))
        );
    }
}
