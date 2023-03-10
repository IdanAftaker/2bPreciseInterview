package com.example.interview2bprecise.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "REPORTS")
public class ReportEntity implements BaseEntity {
    public static final int MAX_TEXT_LENGTH_IN_DB = 320;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;

    @Column(length = MAX_TEXT_LENGTH_IN_DB)
    private String text;

    @Column
    @Temporal(TemporalType.DATE)
    private Date reportDate;

    @Column
    private Long reporterPk;

    @Column
    private Long ownerPk;


    public ReportEntity() {
    }

    public ReportEntity(String text, Date reportDate, Long reporterPk, Long ownerPk) {
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
        return "ReportEntity{" +
                "pk=" + pk +
                ", text='" + text + '\'' +
                ", reportDate=" + reportDate +
                ", reporterPk=" + reporterPk +
                ", ownerPk=" + ownerPk +
                '}';
    }
}
