package com.example.interview2bprecise.dao;

import com.example.interview2bprecise.domain.dto.ReportRequestDTO;
import com.example.interview2bprecise.domain.entities.ReportEntity;
import com.example.interview2bprecise.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportDAOImpl implements ReportDAO {

    @Autowired
    ReportRepository repository;

    @Override
    public List<ReportEntity> getAllReports() {
        return repository.findAll();
    }

    @Override
    public List<ReportEntity> getReportsByOwnerPk(Long ownerPk) {
        return repository.findAll().stream()
                .filter(x -> x.getOwnerPk() != null)
                .filter(x -> x.getOwnerPk().equals(ownerPk)).toList();
    }

    @Override
    public ReportEntity saveReport(ReportRequestDTO requestDTO) {
        ReportEntity entity = new ReportEntity(requestDTO.getText(), requestDTO.getReportDate(),
                requestDTO.getReporterPk(), requestDTO.getOwnerPk());
        repository.save(entity);
        return entity;
    }
}
