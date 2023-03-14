package com.example.interview2bprecise.domain.dto;

import java.util.Date;

public class ReportRequestDTO {
    private String text;
    private Date reportDate;
    private Long reporterPk;
    private Long ownerPk;

    public ReportRequestDTO() {
    }

    public ReportRequestDTO(String text, Date reportDate, Long reporterPk, Long ownerPk) {
        this.text = text;
        this.reportDate = reportDate;
        this.reporterPk = reporterPk;
        this.ownerPk = ownerPk;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Long getReporterPk() {
        return reporterPk;
    }

    public void setReporterPk(Long reporterPk) {
        this.reporterPk = reporterPk;
    }

    public Long getOwnerPk() {
        return ownerPk;
    }

    public void setOwnerPk(Long ownerPk) {
        this.ownerPk = ownerPk;
    }

    @Override
    public String toString() {
        return "ReportRequestDTO{" +
                "text='" + text + '\'' +
                ", reportDate=" + reportDate +
                ", reporterPk=" + reporterPk +
                ", ownerPk=" + ownerPk +
                '}';
    }
}
