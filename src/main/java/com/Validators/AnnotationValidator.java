package com.Validators;

import com.Models.Student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AnnotationValidator implements ConstraintValidator<MyValidation, Student> {
    @Override
    public boolean isValid(Student student, ConstraintValidatorContext constraintValidatorContext) {
        return student.getName().length() == 3;
    }

}
