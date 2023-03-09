package com.example.interview2bprecise.repositories;

import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<AbstractEmployeeEntity, Long> {

}
