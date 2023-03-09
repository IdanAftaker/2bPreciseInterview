package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    List<AbstractEmployeeEntity> getAllEmployees();

    @Query("SELECT * FROM EMPLOYEES  e WHERE e.DISCRIM_EMPLOYEE  = 'Manager'")
    List<AbstractEmployeeEntity> getAllManagers();

    Optional<AbstractEmployeeEntity> getEmployee(Long pk);

    List<AbstractEmployeeEntity> getSubordinates(Long managerPk);
}
