package com.softuni.service;

import com.softuni.domain.dto.forms.UserLoginForm;
import com.softuni.domain.dto.forms.UserRegisterForm;
import com.softuni.domain.dto.models.RoleModel;
import com.softuni.domain.dto.models.UserModel;
import com.softuni.domain.dto.view.UserViewModel;
import com.softuni.domain.entities.Role;
import com.softuni.domain.entities.User;
import com.softuni.domain.enums.RoleName;
import com.softuni.helpers.LoggedUser;
import com.softuni.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTests {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private LoggedUser loggedUser;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RoleService roleService;

    private User user;
    private UserLoginForm userLoginForm;
    private UserModel userModel;

    private UserRegisterForm userRegisterForm;

    @BeforeEach
    public void setUp() {
        userLoginForm = new UserLoginForm() {{
            setUsername("username");
            setPassword("1234");
        }};
        user = new User() {{
            setUsername("username");
            setPassword("1234");
        }};
        userModel = new UserModel();

        userRegisterForm = new UserRegisterForm();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void userService_LoginValidUserTest() {
        // Arrange
        when(userRepository.findByUsername(userLoginForm.getUsername())).thenReturn(Optional.of(user));
        when(modelMapper.map(user, UserModel.class)).thenReturn(userModel);

        // Act
        UserModel result = userService.loginUser(userLoginForm);

        // Assert
        assertNotNull(result);
        assertThat(result).isEqualTo(userModel);
    }

    @Test
    public void userService_LoginInvalidUserTest() {
        // Arrange
        UserLoginForm incorrectForm = new UserLoginForm() {{
            setUsername("username");
            setPassword("4321");
        }};

        when(userRepository.findByUsername(userLoginForm.getUsername())).thenReturn(Optional.of(user));

        // Act
        UserModel result = userService.loginUser(incorrectForm);

        // Assert
        assertThat(result.getId()).isNull();
        assertThat(result.getUsername()).isNull();
    }

    @Test
    public void userService_RegisterUserWithBothRolesTest() {
        // Arrange
        Set<RoleModel> roles = Set.of(
                new RoleModel() {{ setRole(RoleName.ADMIN); }},
                new RoleModel() {{ setRole(RoleName.USER); }}
        );

        when(modelMapper.map(userRegisterForm, UserModel.class)).thenReturn(userModel);
        when(userRepository.count()).thenReturn(0L);
        when(roleService.findAllRoles()).thenReturn(roles);
        when(modelMapper.map(userModel, User.class)).thenReturn(user);
        when(userRepository.saveAndFlush(user)).thenReturn(user);

        // Act
        userService.registerUser(userRegisterForm);

        // Assert
        verify(userRepository).saveAndFlush(user);
    }

    @Test
    public void userService_RegisterWithUserRoleTest() {
        // Arrange
        RoleModel userRoleModel = new RoleModel() {{
            setRole(RoleName.USER);
        }};

        when(modelMapper.map(userRegisterForm, UserModel.class)).thenReturn(userModel);
        when(userRepository.count()).thenReturn(1L);
        when(roleService.findRoleByName(RoleName.USER.name())).thenReturn(userRoleModel);
        when(modelMapper.map(userModel, User.class)).thenReturn(user);
        when(userRepository.saveAndFlush(user)).thenReturn(user);

        // Act
        userService.registerUser(userRegisterForm);

        // Assert
        verify(userRepository).saveAndFlush(user);
    }

    @Test
    public void userService_LogoutTest() {
        // Act
        userService.logout();

        // Assert
        verify(loggedUser).clearFields();
    }

    @Test
    public void userService_FindUserByName_UserExistsTest() {
        // Arrange
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
        when(modelMapper.map(user, UserModel.class)).thenReturn(userModel);

        // Act
        UserModel result = userService.findByUsername(user.getUsername());

        // Assert
        assertNotNull(result);
        assertEquals(userModel, result);
    }

    @Test
    public void userService_FindUserByName_UserNotExistsTest() {
        String notExistingUsername = "wrong_username";

        when(userRepository.findByUsername(notExistingUsername)).thenReturn(Optional.empty());
        when(modelMapper.map(new User(), UserModel.class)).thenReturn(userModel);

        // Act
        UserModel result = userService.findByUsername(notExistingUsername);

        // Assert
        assertEquals(userModel, result);
    }

    @Test
    public void userService_GetLoggedUserProfileTest() {
        // Arrange
        UserViewModel userViewModel = new UserViewModel() {{
            setId(1L);
            setUsername("username");
        }};

        when(loggedUser.getUsername()).thenReturn(user.getUsername());
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
        when(modelMapper.map(Optional.of(user), UserViewModel.class)).thenReturn(userViewModel);

        // Act
        UserViewModel result = userService.getLoggedUserProfile();

        // Assert
        assertEquals(userViewModel, result);
    }

    @Test
    public void userService_GetUserRolesAsStringTest() {
        // Arrange
        Role roleUser = new Role();
        roleUser.setRole(RoleName.USER);

        Role roleAdmin = new Role();
        roleAdmin.setRole(RoleName.ADMIN);

        user.setRoles(new HashSet<>(Arrays.asList(roleAdmin, roleUser)));

        when(loggedUser.getUsername()).thenReturn(user.getUsername());
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));

        // Act
        String result = userService.getUserRolesAsString();

        // Assert
        assertEquals("ADMIN, USER", result);
    }
}
