package com.example.interview2bprecise.domain.dto;

import java.util.Date;

public class TaskRequestDTO implements BaseDTO {
    private Date dueDate;
    private Date assignDate;
    private String description;
    private Long ownerPk;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(Date dueDate, Date assignDate, String description, Long ownerPk) {
        this.dueDate = dueDate;
        this.assignDate = assignDate;
        this.description = description;
        this.ownerPk = ownerPk;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOwnerPk() {
        return ownerPk;
    }

    public void setOwnerPk(Long ownerPk) {
        this.ownerPk = ownerPk;
    }

    @Override
    public String toString() {
        return "TaskRequestDTO{" +
                "dueDate=" + dueDate +
                ", assignDate=" + assignDate +
                ", description='" + description + '\'' +
                ", ownerPk=" + ownerPk +
                '}';
    }
}
