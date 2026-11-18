package com.example.department_service.service;

import com.example.department_service.exception.DepartmentNotFoundException;
import com.example.department_service.model.Department;
import com.example.department_service.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo repo;
    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    public Department getDepartmentByID(Integer id) {
        Optional<Department> dept = repo.findById(id);
        if(dept.isEmpty()){
            throw new DepartmentNotFoundException("Department Not Found with ID - "+id);
        }
        return dept.get();

        // NO Exception --> Service ---> Controller --> Client
        // Exception --> Service  ---> RestControllerAdvise --> Client
    }

    public Department addDepartment(Department department) {
        return repo.save(department);
    }

    public Department updateDepartment(Department department) {
        getDepartmentByID(department.getDepartmentId());
        return repo.save(department);
    }

    public void deleteDepartmentByID(Integer id) {
        getDepartmentByID(id);
        repo.deleteById(id);
    }
}
