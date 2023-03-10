package com.example.interview2bprecise.convertors;

import com.example.interview2bprecise.domain.dto.EmployeeDTO;
import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter implements BaseConverter<AbstractEmployeeEntity> {

    @Override
    public EmployeeDTO convertToDTO(AbstractEmployeeEntity entity) {
        return new EmployeeDTO(entity.getPk(), entity.getFirstName(), entity.getLastName(), entity.getPosition(), entity.getManagerPk());
    }
}
