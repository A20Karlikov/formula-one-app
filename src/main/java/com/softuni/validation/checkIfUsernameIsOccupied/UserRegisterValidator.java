package com.softuni.validation.checkIfUsernameIsOccupied;

import com.softuni.domain.entities.User;
import com.softuni.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class UserRegisterValidator implements ConstraintValidator<ValidateRegisterForm, Object> {

    private String username;
    private String message;

    private final UserRepository userRepository;

    public UserRegisterValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(ValidateRegisterForm constraintAnnotation) {
        this.username = constraintAnnotation.username();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        Optional<User> userToRegister = this.userRepository.findByUsername(this.username);

        if (this.username != null && userToRegister.isEmpty()) {
            return true;
        }

        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(username)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
