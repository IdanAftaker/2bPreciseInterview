package com.example.interview2bprecise.convertors;

import com.example.interview2bprecise.domain.entities.BaseEntity;
import com.example.interview2bprecise.domain.dto.BaseDTO;
import org.springframework.stereotype.Component;

/**
 * Generic converter contains common functionality
 * @param <T> entity that extends BaseEntity
 */
@Component
public interface BaseConverter<T extends BaseEntity> {
    /**
     * Convert Entity into dedicated DTO
     */
    BaseDTO convertToDTO(T entity);
}
