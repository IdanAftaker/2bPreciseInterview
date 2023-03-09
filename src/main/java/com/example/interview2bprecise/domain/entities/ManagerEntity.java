package com.example.interview2bprecise.domain.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "Manager")
public class ManagerEntity extends AbstractEmployeeEntity {
    public ManagerEntity() { }

    public ManagerEntity(String firstName, String lastName, String position) {
        super(firstName, lastName, position);
    }
}
