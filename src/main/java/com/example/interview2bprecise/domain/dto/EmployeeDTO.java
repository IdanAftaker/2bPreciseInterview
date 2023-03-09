package com.example.interview2bprecise.domain.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EmployeeDTO implements BaseDTO {
    private Long pk;
    private String firstName;
    private String lastName;
    private String position;
    private Long managerPk;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long pk, String firstName, String lastName, String position, Long managerPk) {
        this.pk = pk;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.managerPk = managerPk;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public Long getManagerPk() {
        return managerPk;
    }

    public void setManagerPk(Long managerPk) {
        this.managerPk = managerPk;
    }
}
