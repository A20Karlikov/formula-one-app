package com.softuni.controller;

import com.softuni.controllers.ConstructorsController;
import com.softuni.domain.dto.view.ConstructorViewModel;
import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.service.ConstructorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConstructorControllerTests {

    @InjectMocks
    private ConstructorsController constructorsController;

    @Mock
    private ConstructorService constructorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void constructorsController_GetAllTeamsTest() {
        // Arrange
        List<ConstructorViewModel> constructors = List.of(new ConstructorViewModel());

        when(constructorService.getAllConstructors()).thenReturn(constructors);

        // Act
        ModelAndView modelAndView = constructorsController.getAllTeams(new ModelAndView());

        // Assert
        assertEquals("constructors", modelAndView.getViewName());
        assertTrue(modelAndView.getModel().containsKey("constructors"));
        assertEquals(constructors, modelAndView.getModel().get("constructors"));

        verify(constructorService).getAllConstructors();
    }

    @Test
    public void constructorsController_GetTeamDetailsTest() {
        // Arrange
        String name = "Ferrari";
        ConstructorViewModel constructorDetails = new ConstructorViewModel();
        List<DriverViewModel> teamDrivers = List.of(new DriverViewModel());

        when(constructorService.getConstructorByName(name)).thenReturn(constructorDetails);
        when(constructorService.getTeamDrivers(name)).thenReturn(teamDrivers);

        // Act
        ModelAndView modelAndView = constructorsController.getTeamDetails(name, new ModelAndView());

        // Assert
        assertEquals("constructor-details", modelAndView.getViewName());
        assertTrue(modelAndView.getModel().containsKey("constructorDetails"));
        assertEquals(constructorDetails, modelAndView.getModel().get("constructorDetails"));
        assertTrue(modelAndView.getModel().containsKey("drivers"));
        assertEquals(teamDrivers, modelAndView.getModel().get("drivers"));

        verify(constructorService).getConstructorByName(name);
        verify(constructorService).getTeamDrivers(name);
    }
}
