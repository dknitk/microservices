package com.kw.department.service;

import com.kw.department.entity.Department;
import com.kw.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {

        return departmentRepository.findByDepartmentId(departmentId);
    }
}
