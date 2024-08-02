package com.softuni.service;

import com.softuni.domain.dto.forms.UserLoginForm;
import com.softuni.domain.dto.forms.UserRegisterForm;
import com.softuni.domain.dto.models.UserModel;
import com.softuni.domain.entities.User;
import com.softuni.helpers.LoggedUser;
import com.softuni.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    @Autowired
    public UserService(UserRepository userRepository, LoggedUser loggedUser, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    // Login user
    public UserModel loginUser(UserLoginForm userLoginForm) {
        Optional<User> userToBeLogged = this.userRepository.findByUsername(userLoginForm.getUsername());

        UserModel userConfirmation = userToBeLogged.isPresent() && userToBeLogged.get().getPassword().equals(userLoginForm.getPassword())
                ? this.modelMapper.map(userToBeLogged.get(), UserModel.class)
                : new UserModel();

        if (userConfirmation.isValid()) {
            this.loggedUser
                    .setId(userConfirmation.getId())
                    .setUsername(userConfirmation.getUsername())
                    .setRoles(userConfirmation.getRoles());
        }

        return userConfirmation;
    }

    // Register user
    public void registerUser(UserRegisterForm userRegisterForm) {
        final UserModel userModel = this.modelMapper.map(userRegisterForm, UserModel.class);

        userModel.setRoles(this.userRepository.count() == 0 ? this.roleService.findAllRoles() : Set.of(this.roleService.findRoleByName("USER")));

        final User userToRegister = this.modelMapper.map(userModel, User.class);

        this.modelMapper.map(this.userRepository.saveAndFlush(userToRegister), UserModel.class);
    }

    // Logout user
    public void logout() {
        this.loggedUser.clearFields();
    }

    // Find user by username
    public UserModel findByUsername(String username) {
        return this.modelMapper.map(
                this.userRepository
                        .findByUsername(username)
                        .orElse(new User()),
                UserModel.class);
    }
}
