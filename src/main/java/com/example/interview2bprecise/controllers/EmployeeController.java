package com.example.interview2bprecise.controllers;

import com.example.interview2bprecise.domain.dto.EmployeeDTO;
import com.example.interview2bprecise.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/employees/{pk}")
    public EmployeeDTO getEmployee(@PathVariable("pk") Long pk) {
        return service.getEmployee(pk);
    }

    @GetMapping("/managers")
    public List<EmployeeDTO> getAllManagers() {
        return service.getAllManagers();
    }

    @GetMapping("/managers/subordinates/{pk}")
    public List<EmployeeDTO> getSubordinates(@PathVariable("pk") Long managerPk) {
        return service.getSubordinates(managerPk);
    }
}
