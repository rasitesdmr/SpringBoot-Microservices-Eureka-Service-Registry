package com.example.departmentservice.service;

import com.example.departmentservice.model.Department;

public interface DepartmentService {

    Department createDepartment(Department department);
    Department getDepartmentById(Long id);
}
