package com.example.interview2bprecise.convertors;

import com.example.interview2bprecise.domain.dto.BaseDTO;
import com.example.interview2bprecise.domain.dto.TaskDTO;
import com.example.interview2bprecise.domain.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter implements BaseConverter<TaskEntity> {

    @Override
    public TaskDTO convertToDTO(TaskEntity entity) {
        return new TaskDTO(entity.getPk(), entity.getDescription(), entity.getAssignDate(), entity.getDueDate(), entity.getOwnerPk());
    }
}
