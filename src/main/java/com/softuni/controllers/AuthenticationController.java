package com.softuni.controllers;

import com.softuni.domain.dto.forms.UserLoginForm;
import com.softuni.domain.dto.forms.UserRegisterForm;
import com.softuni.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController extends BaseController {

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    // LOGIN
    @GetMapping("/login")
    public ModelAndView getLogin() {
        return super.view("login");
    }

    @PostMapping("/login")
    public ModelAndView onLogin(@Validated UserLoginForm userLoginForm,
                                BindingResult bindingResult,
                                ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            return super.view("login", modelAndView.addObject(userLoginForm));
        }

        return this.userService.loginUser(userLoginForm).isValid()
                ? super.redirect("/")
                : super.redirect("login");
    }

    @ModelAttribute("userLoginForm")
    public UserLoginForm initLoginForm() {
        return new UserLoginForm();
    }


    // LOGOUT
    @GetMapping("/logout")
    public ModelAndView postLogout() {
        this.userService.logout();
        return super.redirect("/");
    }


    // REGISTER
    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {
        return super.view("register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView onRegister(@Valid @ModelAttribute(name = "userRegisterForm") UserRegisterForm userRegisterForm,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterForm", userRegisterForm)
                    .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);

            return super.redirect("register");
        }

        this.userService.registerUser(userRegisterForm);

        return super.redirect("/");
    }

    @ModelAttribute("userRegisterForm")
    public UserRegisterForm initRegisterForm() {
        return new UserRegisterForm();
    }

}
