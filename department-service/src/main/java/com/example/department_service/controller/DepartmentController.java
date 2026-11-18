package com.example.department_service.controller;

import com.example.department_service.model.Department;
import com.example.department_service.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("departments")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        return new ResponseEntity<>(service.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentByID(@PathVariable Integer id){
        System.out.println(environment.getProperty("local.server.port"));
        return new ResponseEntity<>(service.getDepartmentByID(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return new ResponseEntity<>(service.addDepartment(department),HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
        return new ResponseEntity<>(service.updateDepartment(department),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentByID(@PathVariable Integer id){
        service.deleteDepartmentByID(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }



}
