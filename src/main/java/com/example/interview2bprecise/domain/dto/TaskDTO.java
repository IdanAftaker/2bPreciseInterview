package com.example.interview2bprecise.domain.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

/**
 * TaskDTO represent TaskEntity
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TaskDTO implements BaseDTO {
    private Long pk;
    private String description;
    private Date assignDate;
    private Date dueDate;
    private Long ownerPk;

    public TaskDTO() {
    }

    public TaskDTO(Long pk, String description, Date assignDate, Date dueDate, Long ownerPk) {
        this.pk = pk;
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

    @Override
    public String toString() {
        return "TaskDTO{" +
                "pk=" + pk +
                ", description='" + description + '\'' +
                ", assignDate=" + assignDate +
                ", dueDate=" + dueDate +
                ", ownerPk=" + ownerPk +
                '}';
    }
}
