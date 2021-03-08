package com.Controllers;

import com.Converters.StudentToStudentDTOConverter;
import com.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    List<Student> students = new ArrayList<>();

    @Autowired
    StudentToStudentDTOConverter converter;
//    @Autowired
//    StudentRepository repository;

//    @GetMapping("/{id}")
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", path = "/{id}")
    public String sayHello(@PathVariable("id") int studentId){
        return students.get(studentId).toString();
    }

    @PostMapping("/")
    public ResponseEntity<String> addStudent(@Valid @RequestBody Student student, BindingResult errors){
        if (errors.hasErrors()){
            return new ResponseEntity<>(errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList())
                    .toString(),HttpStatus.OK);
        }
        return new ResponseEntity<>("Всё ок", HttpStatus.OK);
    }

//    @GetMapping("/")
//    public String showStudents(){
//        List<StudentDTO> studentDTOS = new ArrayList<>();
//        for (Student s : students) {
//            studentDTOS.add(converter.convert(s));
//        }
//        return studentDTOS.toString();
//    }

//    @PutMapping(path = "/save", consumes = "application/json")
//    public void saveStudent(@Valid @RequestBody Student student){
//        this.students.add(student);
//    }

//    @ExceptionHandler(IndexOutOfBoundsException.class)
//    public String doResolve(IndexOutOfBoundsException e){
//        return e.getMessage();
//    }
    @GetMapping("/hello")
    public ResponseEntity<String> sayHi(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("yes", "no");
        return new ResponseEntity<>("YEAAH", headers, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validate(MethodArgumentNotValidException e){
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
}
