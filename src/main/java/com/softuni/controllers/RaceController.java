package com.softuni.controllers;

import com.softuni.domain.dto.forms.CommentForm;
import com.softuni.service.DriverService;
import com.softuni.service.RaceService;
import com.softuni.service.TrackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/races")
public class RaceController extends BaseController {

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    private final RaceService raceService;
    private final DriverService driverService;
    private final TrackService trackService;

    @Autowired
    public RaceController(RaceService raceService, DriverService driverService, TrackService trackService) {
        this.raceService = raceService;
        this.driverService = driverService;
        this.trackService = trackService;
    }

    @GetMapping("/{id}")
    public ModelAndView getAllRaces(@PathVariable Long id, ModelAndView modelAndView) {
        return super.view(
                "races",
                modelAndView
                        .addObject("raceHeaders", this.raceService.getRaceHeaders())
                        .addObject("raceById", this.raceService.getSelectedRace(id))
                        .addObject("raceId", id)
                        .addObject("comments", this.raceService.getSelectedRaceComments(id))
        );
    }

    @PostMapping("/{id}")
    public ModelAndView onPostComment(
            @PathVariable Long id,
            @Valid @ModelAttribute(name = "commentForm") CommentForm commentForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("commentForm", commentForm)
                    .addFlashAttribute(BINDING_RESULT_PATH + "commentForm", bindingResult);

            return super.redirect("/races/" + id.toString());
        }

        this.raceService.addComment(commentForm, id);

        return super.redirect("/races/" + id.toString());
    }

    @ModelAttribute("commentForm")
    public CommentForm initCommentForm() {
        return new CommentForm();
    }

    @GetMapping("/add")
    public ModelAndView getInputOptions(ModelAndView modelAndView) {
        return super.view(
                "add-new-race",
                    modelAndView
                            .addObject("driversNames", this.driverService.getDriversNames())
                            .addObject("tracksNames", this.trackService.getTracksNames())
                            .addObject("weatherTypes", this.raceService.getRaceWeatherTypes())
                );
    }
}
