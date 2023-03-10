package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.entities.TaskEntity;
import com.example.interview2bprecise.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    TaskRepository repository;

    @Override
    public List<TaskEntity> getAllTasks() {
        return repository.findAll();
    }
}
