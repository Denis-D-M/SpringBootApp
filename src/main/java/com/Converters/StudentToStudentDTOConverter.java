package com.Converters;

import com.DTO.StudentDTO;
import com.Models.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentToStudentDTOConverter implements Converter<Student, StudentDTO> {

    @Override
    public StudentDTO convert(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        return studentDTO;
    }
}
