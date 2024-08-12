package com.softuni.validation.podiumMatcher;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class PodiumMatcher implements ConstraintValidator<PodiumMatch, Object> {

    private String winner;
    private String runnerUp;
    private String thirdPlace;
    private String message;

    @Override
    public void initialize(PodiumMatch constraintAnnotation) {
        this.winner = constraintAnnotation.winner();
        this.runnerUp = constraintAnnotation.runnerUp();
        this.thirdPlace = constraintAnnotation.thirdPlace();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

        Object winnerValue = beanWrapper.getPropertyValue(this.winner);
        Object runnerUpValue = beanWrapper.getPropertyValue(this.runnerUp);
        Object thirdPlaceValue = beanWrapper.getPropertyValue(this.thirdPlace);

        if (
                winnerValue != null &&
                        runnerUpValue != null &&
                        !winnerValue.equals(runnerUpValue) &&
                        !winnerValue.equals(thirdPlaceValue) &&
                        !runnerUpValue.equals(thirdPlaceValue)
        ) {
            return true;
        }

        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(thirdPlace)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();


        return false;
    }
}
