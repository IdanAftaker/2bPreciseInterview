package com.example.interview2bprecise.repositories;

import com.example.interview2bprecise.domain.entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository  extends JpaRepository<ReportEntity, Long> {
}
