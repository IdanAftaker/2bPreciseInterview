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
		AbstractEmployeeEntity managerEntity1 = repository.save(new ManagerEntity("David", "Garcia", "Director", null));
		AbstractEmployeeEntity managerEntity2 = repository.save(new ManagerEntity("Sarah", "Miller", "Team Leader",managerEntity1.getPk()));
		AbstractEmployeeEntity managerEntity3 = repository.save(new ManagerEntity("Emily", "Jones", "Product Manager", managerEntity1.getPk()));
		AbstractEmployeeEntity employeeEntity1 = new EmployeeEntity("John", "Doe", "Data Scientist", managerEntity2.getPk());
		AbstractEmployeeEntity employeeEntity2 = new EmployeeEntity("Jane", "Smith", "Software Engineer", managerEntity2.getPk());
		AbstractEmployeeEntity employeeEntity3 = new EmployeeEntity("Bob", "Johnson", "Automation", managerEntity2.getPk());
		AbstractEmployeeEntity employeeEntity4 = new EmployeeEntity("Alice", "Williams", "Cybersecurity Analyst", managerEntity2.getPk());
		AbstractEmployeeEntity employeeEntity5 = new EmployeeEntity("Mike", "Brown", "UX/UI Designer", managerEntity3.getPk());

		repository.saveAll(List.of(employeeEntity1, employeeEntity2, employeeEntity3, employeeEntity4, employeeEntity5));
	}
}
