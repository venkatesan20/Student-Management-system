package com.example.student_service.controller;

import com.example.student_service.dto.StudentResponse;
import com.example.student_service.model.Student;
import com.example.student_service.service.StudentService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")  //localhost:8080/students
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(service.getAllStudents()
                , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        return new ResponseEntity<>(service.getStudentById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(service.addStudent(student),HttpStatus.CREATED);
    }

    @GetMapping("/details/{id}") //details/4
    public ResponseEntity<StudentResponse> getStudentDetails
            (@PathVariable Integer id){
        return new ResponseEntity<>(
                service.getStudentDetails(id),
                HttpStatus.OK
        );
    }


}
