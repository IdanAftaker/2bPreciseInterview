package com.example.interview2bprecise.controllers;

import com.example.interview2bprecise.domain.dto.EmployeeDTO;
import com.example.interview2bprecise.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = service.getAllEmployees();
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{pk}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("pk") Long pk) {
        try {
            EmployeeDTO employee = service.getEmployee(pk);
            return ResponseEntity.ok(employee);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/managers")
    public ResponseEntity<List<EmployeeDTO>> getAllManagers() {
        List<EmployeeDTO> managers = service.getAllManagers();
        if (managers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(managers);
    }

    @GetMapping("/{pk}/subordinates")
    public ResponseEntity<List<EmployeeDTO>> getSubordinates(@PathVariable("pk") Long managerPk) {
        try {
            List<EmployeeDTO> subordinates = service.getSubordinates(managerPk);
            if (subordinates.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(subordinates);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
