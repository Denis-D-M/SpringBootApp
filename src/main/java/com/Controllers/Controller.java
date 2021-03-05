package com.Controllers;

import com.Converters.StudentToStudentDTOConverter;
import com.DTO.StudentDTO;
import com.Models.Student;
import com.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController()
@Validated
public class Controller {
    List<Student> students = new ArrayList<>();

    @Autowired
    StudentToStudentDTOConverter converter;
    @Autowired
    StudentRepository repository;

//    @GetMapping("/{id}")
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", path = "/{id}")
    public String sayHello(@PathVariable("id") int studentId){
        return students.get(studentId).toString();
    }

    @GetMapping("/")
    public void addStudent(@RequestParam Integer id, @RequestParam String name){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        repository.save(student);
    }

    @GetMapping("/")
    public String showStudents(){
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student s : students) {
            studentDTOS.add(converter.convert(s));
        }
        return studentDTOS.toString();
    }

    @PutMapping(path = "/save", consumes = "application/json")
    public void saveStudent(@Valid @RequestBody Student student){
        this.students.add(student);
    }

//    @ExceptionHandler(IndexOutOfBoundsException.class)
//    public String doResolve(IndexOutOfBoundsException e){
//        return e.getMessage();
//    }
}
