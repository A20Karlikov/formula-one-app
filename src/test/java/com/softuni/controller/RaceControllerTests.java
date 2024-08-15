package com.softuni.controller;

import com.softuni.controllers.RaceController;
import com.softuni.domain.dto.forms.AddNewRaceForm;
import com.softuni.domain.dto.forms.CommentForm;
import com.softuni.domain.dto.view.CommentViewModel;
import com.softuni.domain.dto.view.RaceHeaderViewModel;
import com.softuni.domain.dto.view.RaceViewModel;
import com.softuni.service.DriverService;
import com.softuni.service.RaceService;
import com.softuni.service.TrackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RaceControllerTests {

    @InjectMocks
    private RaceController raceController;

    @Mock
    private RaceService raceService;

    @Mock
    private DriverService driverService;

    @Mock
    private TrackService trackService;

    private Long selectedId;
    private CommentForm commentForm;
    private BindingResult bindingResult;
    private RedirectAttributes redirectAttributes;
    private AddNewRaceForm addNewRaceForm;

    @BeforeEach
    public void setUp() {
        selectedId = 1L;
        commentForm = new CommentForm();
        bindingResult = mock(BindingResult.class);
        redirectAttributes = mock(RedirectAttributes.class);
        addNewRaceForm = new AddNewRaceForm();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void raceController_GetAllRacesTest() {
        // Arrange
        List<RaceHeaderViewModel> raceHeaders = List.of(new RaceHeaderViewModel());
        RaceViewModel selectedRace = new RaceViewModel();
        List<CommentViewModel> selectedRaceComments = List.of(new CommentViewModel());

        when(raceService.getRaceHeaders()).thenReturn(raceHeaders);
        when(raceService.getSelectedRace(selectedId)).thenReturn(selectedRace);
        when(raceService.getSelectedRaceComments(selectedId)).thenReturn(selectedRaceComments);

        // Act
        ModelAndView modelAndView = raceController.getAllRaces(selectedId, new ModelAndView());

        // Assert
        assertEquals("races", modelAndView.getViewName());
        assertEquals(raceHeaders, modelAndView.getModel().get("raceHeaders"));
        assertEquals(selectedRace, modelAndView.getModel().get("raceById"));
        assertEquals(selectedId, modelAndView.getModel().get("raceId"));
        assertEquals(selectedRaceComments, modelAndView.getModel().get("comments"));
    }

    @Test
    public void raceController_PostComment_NoErrorsTest() {
        // Arrange
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        ModelAndView modelAndView = raceController.onPostComment(selectedId, commentForm, bindingResult, redirectAttributes);

        // Assert
        assertEquals("redirect:/races/" + selectedId.toString(), modelAndView.getViewName());
        verify(raceService).addComment(commentForm, selectedId);
    }

    @Test
    public void raceController_PostComment_WithErrorsTest() {
        // Arrange
        when(bindingResult.hasErrors()).thenReturn(true);
        when(redirectAttributes.addFlashAttribute(anyString(), any())).thenReturn(redirectAttributes);

        // Act
        ModelAndView modelAndView = raceController.onPostComment(selectedId, commentForm, bindingResult, redirectAttributes);

        // Assert
        assertEquals("redirect:/races/" + selectedId.toString(), modelAndView.getViewName());
        verify(raceService, times(0)).addComment(commentForm, selectedId);
    }

    @Test
    public void raceController_GetInputOptionsTest() {
        // Arrange
        ModelAndView modelAndView = new ModelAndView();

        List<String> driversNames = List.of("Verstappen", "Hamilton");
        List<String> tracksNames = List.of("Albert Park", "Silverstone");
        List<String> weatherTypes = List.of("SUNNY", "RAINY");

        when(driverService.getDriversNames()).thenReturn(driversNames);
        when(trackService.getTracksNames()).thenReturn(tracksNames);
        when(raceService.getRaceWeatherTypes()).thenReturn(weatherTypes);

        // Act
        ModelAndView result = raceController.getInputOptions(modelAndView);

        // Assert
        assertEquals("add-new-race", result.getViewName());
        assertEquals(driversNames, result.getModel().get("driversNames"));
        assertEquals(tracksNames, result.getModel().get("tracksNames"));
        assertEquals(weatherTypes, result.getModel().get("weatherTypes"));
    }

    @Test
    public void raceController_AddNewRace_NoErrorsTest() {
        // Arrange
        when(bindingResult.hasErrors()).thenReturn(false);
        when(redirectAttributes.addFlashAttribute(any(), any())).thenReturn(redirectAttributes);

        // Act
        ModelAndView modelAndView = raceController.addNewRaceSubmitted(addNewRaceForm, bindingResult, redirectAttributes);

        // Assert
        assertEquals("redirect:/races/1", modelAndView.getViewName());
        verify(raceService, times(1)).addNewRace(addNewRaceForm);
    }

    @Test
    public void raceController_AddNewRace_WithErrorsTest() {
        // Arrange
        when(bindingResult.hasErrors()).thenReturn(true);
        when(redirectAttributes.addFlashAttribute(any(), any())).thenReturn(redirectAttributes);

        // Act
        ModelAndView modelAndView = raceController.addNewRaceSubmitted(addNewRaceForm, bindingResult, redirectAttributes);

        // Assert
        assertEquals("redirect:/races/add", modelAndView.getViewName());
        verify(raceService, times(0)).addNewRace(addNewRaceForm);
    }
}
