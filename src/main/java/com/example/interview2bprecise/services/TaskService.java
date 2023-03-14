package com.example.interview2bprecise.services;

import com.example.interview2bprecise.convertors.TaskConverter;
import com.example.interview2bprecise.dao.TaskDAO;
import com.example.interview2bprecise.domain.dto.TaskDTO;
import com.example.interview2bprecise.domain.dto.TaskRequestDTO;
import com.example.interview2bprecise.domain.entities.TaskEntity;
import com.example.interview2bprecise.validators.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to handle all business logic for tasks
 */
@Service
public class TaskService {

    @Autowired
    TaskDAO dao;

    @Autowired
    TaskConverter converter;

    @Autowired
    TaskValidator validator;

    public List<TaskDTO> getAllTasks(){
        List<TaskEntity> entities = dao.getAllTasks();
        return entities.stream().map(e -> converter.convertToDTO(e)).toList();
    }

    public List<TaskDTO> getTasksByOwnerPk(Long ownerPk) throws Exception {
        validator.validatePK(ownerPk);
        List<TaskEntity> entities = dao.getTasksByOwnerPk(ownerPk);
        return entities.stream().map(e -> converter.convertToDTO(e)).toList();
    }

    public TaskDTO saveTask(TaskRequestDTO requestDTO) {
        TaskEntity entity = dao.saveTask(requestDTO);
        return converter.convertToDTO(entity);
    }
}
