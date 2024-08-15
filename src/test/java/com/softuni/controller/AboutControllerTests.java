package com.softuni.controller;

import com.softuni.controllers.AboutController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutControllerTests {

    @InjectMocks
    private AboutController aboutController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void aboutController_GetAboutTest() {
        // Act
        ModelAndView modelAndView = aboutController.getAbout(new ModelAndView());

        // Assert
        assertEquals("about", modelAndView.getViewName());
    }
}
