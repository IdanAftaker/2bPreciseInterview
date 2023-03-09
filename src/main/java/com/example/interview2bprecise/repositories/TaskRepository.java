package com.example.interview2bprecise.repositories;

import com.example.interview2bprecise.domain.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
