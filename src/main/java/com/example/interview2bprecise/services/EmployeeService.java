package com.example.interview2bprecise.services;

import com.example.interview2bprecise.convertors.EmployeeConverter;
import com.example.interview2bprecise.dao.EmployeeDAO;
import com.example.interview2bprecise.domain.dto.EmployeeDTO;
import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import com.example.interview2bprecise.validators.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to handle all business logic for employees
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeDAO dao;

    @Autowired
    EmployeeConverter convertor;

    @Autowired
    EmployeeValidator validator;

    public List<EmployeeDTO> getAllEmployees() {
        List<AbstractEmployeeEntity> employeeEntities =  dao.getAllEmployees();
        return employeeEntities.stream().map(e -> convertor.convertToDTO(e)).toList();
    }

    public List<EmployeeDTO> getAllManagers() {
        List<AbstractEmployeeEntity> managersEntities =  dao.getAllManagers();
        return managersEntities.stream().map(e -> convertor.convertToDTO(e)).toList();
    }

    public EmployeeDTO getEmployee(Long pk) {
        AbstractEmployeeEntity employeeEntity = dao.getEmployee(pk).orElseThrow();
        return convertor.convertToDTO(employeeEntity);
    }

    public List<EmployeeDTO> getSubordinates(Long managerPk) {
        List<AbstractEmployeeEntity> employeeEntities =  dao.getSubordinates(managerPk);
        return employeeEntities.stream().map(e -> convertor.convertToDTO(e)).toList();
    }
}
