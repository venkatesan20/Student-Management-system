package com.example.student_service.dto;

import lombok.Data;

@Data
public class DepartmentDTO {
    private Integer departmentId;
    private String departmentName;
    private String HOD;
    private String location;
    private Boolean isNbaAccredited;
}
