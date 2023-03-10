package com.example.interview2bprecise.convertors;

import com.example.interview2bprecise.domain.dto.ReportDTO;
import com.example.interview2bprecise.domain.entities.ReportEntity;
import org.springframework.stereotype.Component;

@Component
public class ReportConverter implements BaseConverter<ReportEntity> {
    @Override
    public ReportDTO convertToDTO(ReportEntity entity) {
        return new ReportDTO(entity.getPk(), entity.getText(), entity.getReportDate(), entity.getReporterPk(), entity.getOwnerPk());
    }
}
