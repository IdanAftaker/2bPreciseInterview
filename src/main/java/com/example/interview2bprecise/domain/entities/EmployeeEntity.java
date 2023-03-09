package com.example.interview2bprecise.domain.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "Employee")
public class EmployeeEntity extends AbstractEmployeeEntity {
	public EmployeeEntity() { }

	public EmployeeEntity(String firstName, String lastName, String position) {
		super(firstName, lastName, position);
	}
}
