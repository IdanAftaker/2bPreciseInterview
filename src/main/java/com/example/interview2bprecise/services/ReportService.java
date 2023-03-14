package com.example.interview2bprecise.services;

import com.example.interview2bprecise.convertors.ReportConverter;
import com.example.interview2bprecise.dao.ReportDAO;
import com.example.interview2bprecise.domain.dto.ReportDTO;
import com.example.interview2bprecise.domain.dto.ReportRequestDTO;
import com.example.interview2bprecise.domain.entities.ReportEntity;
import com.example.interview2bprecise.validators.ReportValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle all business logic for reports
 */
@Service
public class ReportService {

    @Autowired
    ReportDAO dao;

    @Autowired
    ReportConverter converter;

    @Autowired
    ReportValidator validator;

    public List<ReportDTO> getAllReports() {
        List<ReportEntity> entities = dao.getAllReports();
        return entities.stream().map(e -> converter.convertToDTO(e)).toList();
    }

    public List<ReportDTO> getReportsByOwnerPk(Long ownerPk) throws Exception {
        validator.validatePK(ownerPk);
        List<ReportEntity> entities = dao.getReportsByOwnerPk(ownerPk);
        return entities.stream().map(x -> converter.convertToDTO(x)).toList();
    }

    public ReportDTO saveReport(ReportRequestDTO requestDTO) {
        ReportEntity reportEntity = dao.saveReport(requestDTO);
        return converter.convertToDTO(reportEntity);
    }
}

