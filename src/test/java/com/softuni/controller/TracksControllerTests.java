package com.softuni.controller;

import com.softuni.controllers.TracksController;
import com.softuni.domain.dto.view.CountryFlagViewModel;
import com.softuni.domain.dto.view.TrackViewModel;
import com.softuni.service.TrackService;
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

public class TracksControllerTests {

    @InjectMocks
    private TracksController tracksController;

    @Mock
    private TrackService trackService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void tracksController_GetAllTracksTests() {
        // Arrange
        String trackName = "Suzuka";
        TrackViewModel selectedTrack = new TrackViewModel();
        List<CountryFlagViewModel> countryFlags = List.of(new CountryFlagViewModel());

        when(trackService.getSelectedTrack(trackName)).thenReturn(selectedTrack);
        when(trackService.getCountryFlagsInfo()).thenReturn(countryFlags);

        // Act
        ModelAndView modelAndView = tracksController.getAllTracks(trackName, new ModelAndView());

        // Assert
        assertEquals("tracks", modelAndView.getViewName());
        assertTrue(modelAndView.getModel().containsKey("trackByCountry"));
        assertEquals(selectedTrack, modelAndView.getModel().get("trackByCountry"));
        assertTrue(modelAndView.getModel().containsKey("countryFlags"));
        assertEquals(countryFlags, modelAndView.getModel().get("countryFlags"));

        verify(trackService).getSelectedTrack(trackName);
        verify(trackService).getCountryFlagsInfo();
    }
}
