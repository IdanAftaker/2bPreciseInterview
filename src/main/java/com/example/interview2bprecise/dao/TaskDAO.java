package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.entities.TaskEntity;

import java.util.List;

/**
 * Data Access Object for tasks
 */
public interface TaskDAO {

    /**
     * Get all tasks
     */
    List<TaskEntity> getAllTasks();

    List<TaskEntity> getTasksByOwnerPk(Long ownerPk);
}
