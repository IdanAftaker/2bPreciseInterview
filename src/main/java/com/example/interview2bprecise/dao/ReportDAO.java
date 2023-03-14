package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.dto.ReportRequestDTO;
import com.example.interview2bprecise.domain.entities.ReportEntity;

import java.util.List;

/**
 * Data Access Object for reports
 */
public interface ReportDAO {

    /**
     * Get all reports
     */
    List<ReportEntity> getAllReports();

    List<ReportEntity> getReportsByOwnerPk(Long ownerPk);

    ReportEntity saveReport(ReportRequestDTO requestDTO);
}
