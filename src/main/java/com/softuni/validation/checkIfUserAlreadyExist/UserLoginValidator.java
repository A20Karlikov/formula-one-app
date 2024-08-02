package com.softuni.validation.checkIfUserAlreadyExist;

import com.softuni.domain.dto.forms.UserLoginForm;
import com.softuni.domain.dto.models.UserModel;
import com.softuni.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginForm> {

    private final UserService userService;

    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginForm userLoginModel, ConstraintValidatorContext constraintValidatorContext) {
        UserModel user = this.userService.findByUsername(userLoginModel.getUsername());

        return user.getId() != null
                && user.getPassword()
                .equals(userLoginModel.getPassword());
    }
}
