package com.example.interview2bprecise.domain.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "Manager")
public class ManagerEntity extends AbstractEmployeeEntity {

    public ManagerEntity() { }

    public ManagerEntity(String firstName, String lastName, String position, Long managerPk) {
        super(firstName, lastName, position, managerPk);
    }

    @Override
    public String toString() {
        return "ManagerEntity{" +
                "pk=" + getPk() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", managerPk=" + getManagerPk() +
                '}';
    }
}
