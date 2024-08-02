package com.softuni.validation.checkIfUsernameIsOccupied;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UserRegisterValidator.class)
public @interface ValidateRegisterForm {

    String username();

    String message() default "Username is already occupied";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
