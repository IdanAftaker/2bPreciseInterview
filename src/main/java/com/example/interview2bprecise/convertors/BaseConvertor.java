package com.example.interview2bprecise.convertors;

import com.example.interview2bprecise.domain.entities.BaseEntity;
import com.example.interview2bprecise.domain.dto.BaseDTO;
import org.springframework.stereotype.Component;

@Component
public interface BaseConvertor<T extends BaseEntity> {
    BaseDTO convertToDTO(T entity);
}
