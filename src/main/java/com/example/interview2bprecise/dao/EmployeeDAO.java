package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
    List<AbstractEmployeeEntity> getAllEmployees();
}
