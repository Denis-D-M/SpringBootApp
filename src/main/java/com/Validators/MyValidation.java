package com.Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AnnotationValidator.class)
@Target(ElementType.TYPE)
public @interface MyValidation {
    String message() default "My stupid validation required three character name ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
