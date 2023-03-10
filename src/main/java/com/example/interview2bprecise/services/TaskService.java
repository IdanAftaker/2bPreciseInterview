package com.example.interview2bprecise.services;

import com.example.interview2bprecise.convertors.TaskConverter;
import com.example.interview2bprecise.dao.TaskDAO;
import com.example.interview2bprecise.domain.dto.TaskDTO;
import com.example.interview2bprecise.domain.entities.TaskEntity;
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

    public List<TaskDTO> getAllTasks(){
        List<TaskEntity> entities = dao.getAllTasks();
        return entities.stream().map(e -> converter.convertToDTO(e)).toList();
    }
}
