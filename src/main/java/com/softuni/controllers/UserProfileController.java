package com.softuni.controllers;

import com.softuni.domain.dto.view.UserViewModel;
import com.softuni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserProfileController extends BaseController {

    private final UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ModelAndView getUserProfile(ModelAndView modelAndView) {
        UserViewModel userProfile = this.userService.getLoggedUserProfile();

        return super.view(
                "profile",
                modelAndView
                        .addObject("profile", this.userService.getLoggedUserProfile())
                        .addObject("roles", this.userService.getUserRolesAsString())
        );
    }

    @GetMapping("/admin")
    public ModelAndView getAdminProfile(ModelAndView modelAndView) {
        return super.view("admin", modelAndView);
    }
}
