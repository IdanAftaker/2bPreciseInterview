package com.example.interview2bprecise.dao;

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
}
