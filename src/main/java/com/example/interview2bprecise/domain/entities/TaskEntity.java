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
@Table(name = "TASKS")
public class TaskEntity implements BaseEntity {
    public static final int MAX_DESC_LENGTH_IN_DB = 320;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;

    @Column(length = MAX_DESC_LENGTH_IN_DB)
    private String description;

    @Column
    @Temporal(TemporalType.DATE)
    private Date assignDate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column
    private Long ownerPk;

    public TaskEntity() {
    }

    public TaskEntity(String description, Date assignDate, Date dueDate, Long ownerPk) {
        this.description = description;
        this.assignDate = assignDate;
        this.dueDate = dueDate;
        this.ownerPk = ownerPk;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Long getOwnerPk() {
        return ownerPk;
    }

    public void setOwnerPk(Long ownerPk) {
        this.ownerPk = ownerPk;
    }
}
