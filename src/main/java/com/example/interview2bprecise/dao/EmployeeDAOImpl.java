package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import com.example.interview2bprecise.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    EmployeeRepository repository;


    @Override
    public List<AbstractEmployeeEntity> getAllEmployees() {
        return repository.findAll();
    }
}
