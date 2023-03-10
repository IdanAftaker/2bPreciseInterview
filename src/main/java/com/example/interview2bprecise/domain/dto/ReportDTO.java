package com.example.interview2bprecise.domain.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

/**
 * ReportDTO represent ReportEntity
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ReportDTO implements BaseDTO {
    private Long pk;
    private String text;
    private Date reportDate;
    private Long reporterPk;
    private Long ownerPk;

    public ReportDTO() {
    }

    public ReportDTO(Long pk, String text, Date reportDate, Long reporterPk, Long ownerPk) {
        this.pk = pk;
        this.text = text;
        this.reportDate = reportDate;
        this.reporterPk = reporterPk;
        this.ownerPk = ownerPk;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
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
        return "ReportDTO{" +
                "pk=" + pk +
                ", text='" + text + '\'' +
                ", reportDate=" + reportDate +
                ", reporterPk=" + reporterPk +
                ", ownerPk=" + ownerPk +
                '}';
    }
}
