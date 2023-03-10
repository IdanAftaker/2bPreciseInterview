package com.example.interview2bprecise.services;

import com.example.interview2bprecise.convertors.ReportConverter;
import com.example.interview2bprecise.dao.ReportDAO;
import com.example.interview2bprecise.domain.dto.ReportDTO;
import com.example.interview2bprecise.domain.entities.ReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to handle all business logic for reports
 */
@Service
public class ReportService {

    @Autowired
    ReportDAO dao;

    @Autowired
    ReportConverter converter;

    public List<ReportDTO> getAllReports() {
        List<ReportEntity> entities = dao.getAllReports();
        return entities.stream().map(e -> converter.convertToDTO(e)).toList();
    }
}
