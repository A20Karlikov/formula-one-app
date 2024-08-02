package com.softuni.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {

    private static final String USERNAME_SESSION_KEY = "username";

    @Autowired
    public HomeController() {
    }

    @GetMapping
    public ModelAndView getHome(ModelAndView modelAndView, HttpSession httpSession) {
        final String username = httpSession.getAttribute(USERNAME_SESSION_KEY) != null
                ? httpSession.getAttribute(USERNAME_SESSION_KEY).toString()
                : "";

        modelAndView.addObject(USERNAME_SESSION_KEY, username);

        return super.view("index", modelAndView);
    }
}
