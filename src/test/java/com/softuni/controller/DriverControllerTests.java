package com.softuni.controller;

import com.softuni.controllers.DriverController;
import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.service.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DriverControllerTests {

    @InjectMocks
    private DriverController driverController;

    @Mock
    private DriverService driverService;

    private DriverViewModel driverLewis;
    private DriverViewModel driverCheco;
    List<DriverViewModel> drivers = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        driverLewis = new DriverViewModel() {{
            setName("Lewis");
            setNumberOfWins(100);
        }};

        driverCheco = new DriverViewModel() {{
            setName("Checo");
            setNumberOfWins(30);
        }};

        drivers.add(driverLewis);
        drivers.add(driverCheco);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void driverController_GetAllDriversTest() {
        // Arrange

        when(driverService.getAllDrivers()).thenReturn(drivers);

        // Act
        ModelAndView modelAndView = driverController.getAllDrivers(new ModelAndView());

        // Assert
        assertEquals("drivers", modelAndView.getViewName());
        assertTrue(modelAndView.getModel().containsKey("drivers"));
        assertEquals(drivers, modelAndView.getModel().get("drivers"));

        verify(driverService).getAllDrivers();
    }

    @Test
    public void driverController_GetDriverDetailsTest() {
        // Arrange
        DriverViewModel driverViewModel = new DriverViewModel();

        when(driverService.getDriverDetails(driverCheco.getName())).thenReturn(driverViewModel);

        // Act
        ModelAndView modelAndView = driverController.getDriverDetails(driverCheco.getName(), new ModelAndView());

        // Assert
        assertEquals("driver-details", modelAndView.getViewName());
        assertTrue(modelAndView.getModel().containsKey("driverDetails"));
        assertEquals(driverViewModel, modelAndView.getModel().get("driverDetails"));

        verify(driverService).getDriverDetails(driverCheco.getName());
    }
}
