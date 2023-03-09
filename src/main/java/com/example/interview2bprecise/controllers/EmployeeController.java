package com.example.interview2bprecise.controllers;

import com.example.interview2bprecise.domain.dto.EmployeeDTO;
import com.example.interview2bprecise.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees() {
        return service.getAllEmployees();
    }
}
