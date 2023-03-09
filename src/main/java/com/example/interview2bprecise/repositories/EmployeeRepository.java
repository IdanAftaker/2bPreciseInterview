package com.example.interview2bprecise.repositories;

import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<AbstractEmployeeEntity, Long> {
    @Query(value = "SELECT * FROM EMPLOYEES  e WHERE e.DISCRIM_EMPLOYEE  = 'Manager'", nativeQuery = true)
    List<AbstractEmployeeEntity> findAllManagers();

    @Query(value = "SELECT * FROM EMPLOYEES  e WHERE e.MANAGER_PK  = :managerPk", nativeQuery = true)
    List<AbstractEmployeeEntity> getSubordinates(@Param("managerPk") Long managerPk);
}
