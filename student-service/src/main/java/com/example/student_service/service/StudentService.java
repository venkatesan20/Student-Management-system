package com.example.student_service.service;

import com.example.student_service.dto.DepartmentDTO;
import com.example.student_service.dto.StudentResponse;
import com.example.student_service.exception.StudentNotFoundException;
import com.example.student_service.feign.DepartmentClient;
import com.example.student_service.model.Student;
import com.example.student_service.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    @Autowired
    private DepartmentClient departmentClient;
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student addStudent(Student student) {
        // Department Id validation will be done later...
        Integer deptId = student.getDepartmentId();
        departmentClient.getDepartmentByID(deptId); //FeignException
        return repo.save(student);
    }

    public Student getStudentById(Integer id) {  // 1 - Trent 2-Kira
        Optional<Student> student =  repo.findById(id); // students/3
        if(student.isEmpty()){
            throw new StudentNotFoundException("No Student Exists with ID - "+id);
        }
        return student.get();
    }

    public StudentResponse getStudentDetails(Integer id) {
        Student student = getStudentById(id);
        StudentResponse response = new StudentResponse();
        response.setStudentId(id);
        response.setStudentName(student.getName());
        response.setEmail(student.getEmail());

        Integer deptId = student.getDepartmentId();
        DepartmentDTO departmentDTO =
                departmentClient.getDepartmentByID(deptId).getBody();

        response.setDepartmentDTO(departmentDTO);
        return response;
    }
}
