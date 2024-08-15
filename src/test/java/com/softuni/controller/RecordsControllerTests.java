package com.softuni.controller;

import com.softuni.controllers.RecordsController;
import com.softuni.domain.dto.view.ConstructorViewModel;
import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.domain.dto.view.TrackViewModel;
import com.softuni.service.ConstructorService;
import com.softuni.service.DriverService;
import com.softuni.service.TrackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecordsControllerTests {

    @InjectMocks
    private RecordsController recordsController;

    @Mock
    private DriverService driverService;

    @Mock
    private ConstructorService constructorService;

    @Mock
    private TrackService trackService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void recordsController_GetAllRecordsTest() {
        // Arrange
        DriverViewModel driverMostWins = new DriverViewModel() {{
            setName("Lewis Hamilton");
        }};
        DriverViewModel driverMostPodiums = new DriverViewModel() {{
            setName("Lewis Hamilton");
        }};
        ConstructorViewModel constructorWithMostWins = new ConstructorViewModel() {{
            setName("Ferrari");
        }};
        ConstructorViewModel constructorWithMostTitles = new ConstructorViewModel() {{
            setName("Aston Martin");
        }};
        ConstructorViewModel oldestConstructor = new ConstructorViewModel() {{
            setName("Ford");
        }};
        ConstructorViewModel youngestConstructor = new ConstructorViewModel() {{
            setName("Haas");
        }};
        TrackViewModel trackWithMostLaps = new TrackViewModel() {{
            setName("Interlagos");
        }};
        TrackViewModel oldestTrack = new TrackViewModel() {{
            setName("Monza");
        }};
        String countryWithMostDrivers = "Great Britain";

        when(driverService.getDriverWithMostWins()).thenReturn(driverMostWins);
        when(driverService.getDriverWithMostPodiums()).thenReturn(driverMostPodiums);
        when(driverService.getCountryWithMostDrivers()).thenReturn(countryWithMostDrivers);
        when(constructorService.getConstructorWithMostWins()).thenReturn(constructorWithMostWins);
        when(constructorService.getConstructorWithMostTitles()).thenReturn(constructorWithMostTitles);
        when(constructorService.getOldestConstructor()).thenReturn(oldestConstructor);
        when(constructorService.getYoungestConstructor()).thenReturn(youngestConstructor);
        when(trackService.getTrackWithMostLaps()).thenReturn(trackWithMostLaps);
        when(trackService.getOldestTrack()).thenReturn(oldestTrack);

        // Act
        ModelAndView modelAndView = recordsController.getAllRecords(new ModelAndView());

        // Assert
        assertEquals("records", modelAndView.getViewName());
        assertEquals(driverMostWins, modelAndView.getModel().get("driverMostWins"));
        assertEquals(driverMostPodiums, modelAndView.getModel().get("driverMostPodiums"));
        assertEquals(countryWithMostDrivers, modelAndView.getModel().get("countryWithMostDrivers"));
        assertEquals(constructorWithMostWins, modelAndView.getModel().get("constructorWithMostWins"));
        assertEquals(constructorWithMostTitles, modelAndView.getModel().get("constructorWithMostTitles"));
        assertEquals(oldestConstructor, modelAndView.getModel().get("oldestConstructor"));
        assertEquals(youngestConstructor, modelAndView.getModel().get("youngestConstructor"));
        assertEquals(trackWithMostLaps, modelAndView.getModel().get("trackWithMostLaps"));
        assertEquals(oldestTrack, modelAndView.getModel().get("oldestTrack"));
    }
}
