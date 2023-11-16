package com.dictionaryapp.validation;

import com.dictionaryapp.model.annotation.StringDateInThePastOrPresent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class StringDateInThePastOrPresentValidator implements ConstraintValidator<StringDateInThePastOrPresent, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value != null && !value.isBlank()) {
            LocalDate parse = LocalDate.parse(value);
            if(parse.isBefore(LocalDate.now())) {
                return parse.isBefore(LocalDate.now());
            } else {
                return parse.isEqual(LocalDate.now());
            }
        }
        return false;
    }
}
