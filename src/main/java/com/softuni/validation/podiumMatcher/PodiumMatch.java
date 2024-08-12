package com.softuni.validation.podiumMatcher;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PodiumMatcher.class)
public @interface PodiumMatch {

    String winner();

    String runnerUp();

    String thirdPlace();

    String message() default "Drivers on the podium should be different";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
