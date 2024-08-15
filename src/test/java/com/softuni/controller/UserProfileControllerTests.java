package com.softuni.controller;

import com.softuni.controllers.UserProfileController;
import com.softuni.domain.dto.view.UserViewModel;
import com.softuni.domain.enums.RoleName;
import com.softuni.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserProfileControllerTests {

    @InjectMocks
    private UserProfileController userProfileController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void userProfileController_GetUserProfileTest() {
        // Arrange
        UserViewModel userProfile = new UserViewModel();
        String userRoles = RoleName.ADMIN.name() + ", " +  RoleName.USER.name();

        when(userService.getLoggedUserProfile()).thenReturn(userProfile);
        when(userService.getUserRolesAsString()).thenReturn(userRoles);

        // Act
        ModelAndView modelAndView = userProfileController.getUserProfile(new ModelAndView());

        // Assert
        assertEquals("profile", modelAndView.getViewName());
        assertTrue(modelAndView.getModel().containsKey("profile"));
        assertEquals(userProfile, modelAndView.getModel().get("profile"));
        assertTrue(modelAndView.getModel().containsKey("roles"));
        assertEquals(userRoles, modelAndView.getModel().get("roles"));

        verify(userService).getLoggedUserProfile();
        verify(userService).getUserRolesAsString();
    }

    @Test
    public void userProfileController_GetAdminProfileTest() {
        // Arrange
        String expectedViewName = "admin";

        // Act
        ModelAndView modelAndView = userProfileController.getAdminProfile(new ModelAndView());

        // Assert
        assertEquals(expectedViewName, modelAndView.getViewName());
    }
}
