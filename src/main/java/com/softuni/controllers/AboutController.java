package com.softuni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/about")
public class AboutController extends BaseController {

    @Autowired
    public AboutController() {
    }

    @GetMapping
    public ModelAndView getAbout(ModelAndView modelAndView) {
        return super.view("about", modelAndView);
    }
}
