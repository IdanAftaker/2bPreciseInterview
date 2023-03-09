package com.example.interview2bprecise.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "PERSON")
@DiscriminatorColumn(name = "DISCRIM_PERSON", columnDefinition = "VARCHAR(32) DEFAULT 'Employee' NOT NULL")
public abstract class AbstractEmployeeEntity implements BaseEntity {

	public static final int MAX_NAME_LENGTH_IN_DB = 64;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pk;

	@Column(length = MAX_NAME_LENGTH_IN_DB)
	private String firstName;

	@Column(length = MAX_NAME_LENGTH_IN_DB)
	private String lastName;

	@Column(length = MAX_NAME_LENGTH_IN_DB)
	private String position;


	public AbstractEmployeeEntity() { }

	public AbstractEmployeeEntity(String firstName, String lastName, String position) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
	}

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
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

	@Override
	public String toString() {
		return "AbstractEmployeeEntity{" +
				"pk=" + pk +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", position='" + position + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractEmployeeEntity that = (AbstractEmployeeEntity) o;
		return pk.equals(that.pk);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pk);
	}
}
