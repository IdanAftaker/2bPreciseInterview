package com.example.interview2bprecise.configs;

import com.example.interview2bprecise.domain.entities.AbstractEmployeeEntity;
import com.example.interview2bprecise.domain.entities.EmployeeEntity;
import com.example.interview2bprecise.domain.entities.ManagerEntity;
import com.example.interview2bprecise.domain.entities.ReportEntity;
import com.example.interview2bprecise.domain.entities.TaskEntity;
import com.example.interview2bprecise.repositories.EmployeeRepository;
import com.example.interview2bprecise.repositories.ReportRepository;
import com.example.interview2bprecise.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Class to initialize all data
 */
@Component
public class DataBaseLoader implements CommandLineRunner {
	final EmployeeRepository employeeRepository;
	final TaskRepository taskRepository;
	final ReportRepository reportRepository;

	public DataBaseLoader(EmployeeRepository employeeRepository, TaskRepository taskRepository, ReportRepository reportRepository) {
		this.employeeRepository = employeeRepository;
		this.taskRepository = taskRepository;
		this.reportRepository = reportRepository;
	}

	@Override
	public void run(String... args) throws Exception
	{
		// Add employees
		AbstractEmployeeEntity managerEntity1 = employeeRepository.save(new ManagerEntity("David", "Garcia", "Director", null));
		AbstractEmployeeEntity managerEntity2 = employeeRepository.save(new ManagerEntity("Sarah", "Miller", "Team Leader",managerEntity1.getPk()));
		AbstractEmployeeEntity managerEntity3 = employeeRepository.save(new ManagerEntity("Emily", "Jones", "Product Manager", managerEntity1.getPk()));
		AbstractEmployeeEntity employeeEntity1 = new EmployeeEntity("John", "Doe", "Data Scientist", managerEntity2.getPk());
		AbstractEmployeeEntity employeeEntity2 = new EmployeeEntity("Jane", "Smith", "Software Engineer", managerEntity2.getPk());
		AbstractEmployeeEntity employeeEntity3 = new EmployeeEntity("Bob", "Johnson", "Automation", managerEntity2.getPk());
		AbstractEmployeeEntity employeeEntity4 = new EmployeeEntity("Alice", "Williams", "Cybersecurity Analyst", managerEntity2.getPk());
		AbstractEmployeeEntity employeeEntity5 = new EmployeeEntity("Mike", "Brown", "UX/UI Designer", managerEntity3.getPk());
		employeeRepository.saveAll(List.of(employeeEntity1, employeeEntity2, employeeEntity3, employeeEntity4, employeeEntity5));

		// Add tasks
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7);
		TaskEntity task1 = new TaskEntity("Task1", new Date(), cal.getTime(), employeeEntity1.getPk());
		TaskEntity task2 = new TaskEntity("Task2", new Date(), cal.getTime(), null);
		TaskEntity task3 = new TaskEntity("Task3", new Date(), cal.getTime(), null);
		TaskEntity task4 = new TaskEntity("Task4", new Date(), cal.getTime(), null);
		taskRepository.saveAll(List.of(task1, task2, task3, task4));

		// Add reports
		cal.add(Calendar.DATE, -9);
		ReportEntity report1 = new ReportEntity("Task 1 should be done today", cal.getTime(), employeeEntity1.getPk(), employeeEntity1.getManagerPk());
		reportRepository.saveAll(List.of(report1));

	}
}
