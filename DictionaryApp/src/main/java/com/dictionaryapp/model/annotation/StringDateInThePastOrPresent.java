package com.dictionaryapp.model.annotation;


import com.dictionaryapp.validation.StringDateInThePastOrPresentValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringDateInThePastOrPresentValidator.class)
public @interface StringDateInThePastOrPresent {

    String message() default "The input date must be in the past or present!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
