package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.dto.TaskRequestDTO;
import com.example.interview2bprecise.domain.entities.TaskEntity;
import com.example.interview2bprecise.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    TaskRepository repository;

    @Override
    public List<TaskEntity> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public List<TaskEntity> getTasksByOwnerPk(Long ownerPk) {
        return repository.findAll().stream()
                .filter(x -> x.getOwnerPk() != null)
                .filter(x -> x.getOwnerPk().equals(ownerPk)).toList();
    }

    @Override
    public TaskEntity saveTask(TaskRequestDTO requestDTO) {
        TaskEntity entity = new TaskEntity(requestDTO.getDescription(), requestDTO.getAssignDate(),
                requestDTO.getDueDate(), requestDTO.getOwnerPk());
        repository.save(entity);
        return entity;
    }
}
