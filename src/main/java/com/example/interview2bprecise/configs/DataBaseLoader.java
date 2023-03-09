package com.example.interview2bprecise.configs;

import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import com.example.interview2bprecise.domain.entities.EmployeeEntity;
import com.example.interview2bprecise.domain.entities.ManagerEntity;
import com.example.interview2bprecise.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataBaseLoader implements CommandLineRunner {
	final EmployeeRepository repository;

	public DataBaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception
	{
		AbstractEmployeeEntity employeeEntity1 = new EmployeeEntity("John", "Doe", "Data Scientist");
		AbstractEmployeeEntity employeeEntity2 = new EmployeeEntity("Jane", "Smith", "Software Engineer");
		AbstractEmployeeEntity employeeEntity3 = new EmployeeEntity("Bob", "Johnson", "Automation");
		AbstractEmployeeEntity employeeEntity4 = new EmployeeEntity("Alice", "Williams", "Cybersecurity Analyst");
		AbstractEmployeeEntity employeeEntity5 = new EmployeeEntity("Mike", "Brown", "UX/UI Designer");
		AbstractEmployeeEntity managerEntity1 = new ManagerEntity("Sarah", "Miller", "Team Leader");
		AbstractEmployeeEntity managerEntity2 = new EmployeeEntity("Emily", "Jones", "Product Manager");
		AbstractEmployeeEntity managerEntity3 = new EmployeeEntity("David", "Garcia", "Director");

		repository.saveAll(List.of(employeeEntity1, employeeEntity2, employeeEntity3, employeeEntity4, employeeEntity5,
				managerEntity1, managerEntity2, managerEntity3));
	}
}
