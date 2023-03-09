package com.example.interview2bprecise.services;

import com.example.interview2bprecise.convertors.EmployeeConvertor;
import com.example.interview2bprecise.dao.EmployeeDAO;
import com.example.interview2bprecise.domain.dto.EmployeeDTO;
import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDAO dao;

    @Autowired
    EmployeeConvertor convertor;

    public List<EmployeeDTO> getAllEmployees() {
        List<AbstractEmployeeEntity> employeeEntities =  dao.getAllEmployees();
        return employeeEntities.stream().map(e -> convertor.convertToDTO(e)).collect(Collectors.toList());
    }

}
