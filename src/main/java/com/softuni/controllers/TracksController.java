package com.softuni.controllers;

import com.softuni.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tracks")
public class TracksController extends BaseController {

    private final TrackService trackService;

    @Autowired
    public TracksController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/{name}")
    public ModelAndView getAllTracks(
            @PathVariable String name,
            ModelAndView modelAndView
    ) {
        return super.view(
                        "tracks",
                        modelAndView
                                .addObject("trackByCountry", this.trackService.getSelectedTrack(name)))
                                .addObject("countryFlags", this.trackService.getCountryFlagsInfo());
    }
}
