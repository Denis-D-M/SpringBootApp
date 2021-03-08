package com.Validators;

import com.Models.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MyValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Student student = (Student) o;
        if (student.getId() < 2){
            errors.rejectValue("id", "id не должен быть меньше 2");
        }
    }
}
