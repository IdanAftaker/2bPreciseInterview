package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import com.example.interview2bprecise.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    EmployeeRepository repository;


    @Override
    public List<AbstractEmployeeEntity> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public List<AbstractEmployeeEntity> getAllManagers() {
        return repository.findAllManagers();
    }

    public Optional<AbstractEmployeeEntity> getEmployee(Long pk) {
        return repository.findById(pk);
    }

    @Override
    public List<AbstractEmployeeEntity> getSubordinates(Long managerPk) {
        return repository.getSubordinates(managerPk);
    }
}
