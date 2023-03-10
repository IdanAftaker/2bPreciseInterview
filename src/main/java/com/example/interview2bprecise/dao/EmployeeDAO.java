package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object for employees
 */
public interface EmployeeDAO {

    /**
     * Return all employees
     */
    List<AbstractEmployeeEntity> getAllEmployees();

    /**
     * Return all and only managers
     */
    @Query("SELECT * FROM EMPLOYEES  e WHERE e.DISCRIM_EMPLOYEE  = 'Manager'")
    List<AbstractEmployeeEntity> getAllManagers();

    /**
     * Get employee by pk
     */
    Optional<AbstractEmployeeEntity> getEmployee(Long pk);

    /**
     * Get all subordinates by manager pk
     */
    List<AbstractEmployeeEntity> getSubordinates(Long managerPk);
}
