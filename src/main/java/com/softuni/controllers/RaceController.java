package com.softuni.controllers;

import com.softuni.domain.dto.forms.CommentForm;
import com.softuni.domain.dto.forms.UserRegisterForm;
import com.softuni.service.RaceService;
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
}
