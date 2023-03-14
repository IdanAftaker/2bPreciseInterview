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
		TaskEntity task1 = new TaskEntity("Managing financial resources", new Date(), cal.getTime(), managerEntity1.getPk());
		TaskEntity task2 = new TaskEntity("Setting goals and objectives for the organization", new Date(), cal.getTime(), managerEntity1.getPk());
		TaskEntity task3 = new TaskEntity("Planning and organizing projects", new Date(), cal.getTime(), managerEntity2.getPk());
		TaskEntity task4 = new TaskEntity("Providing technical guidance", new Date(), cal.getTime(), managerEntity2.getPk());
		TaskEntity task5 = new TaskEntity("Developing and implementing best practices", new Date(), cal.getTime(), managerEntity2.getPk());
		TaskEntity task6 = new TaskEntity("Defining product requirements", new Date(), cal.getTime(), managerEntity3.getPk());
		TaskEntity task7 = new TaskEntity("Prioritizing product features", new Date(), cal.getTime(), managerEntity3.getPk());
		TaskEntity task8 = new TaskEntity("Managing product development timelines", new Date(), cal.getTime(), managerEntity3.getPk());
		TaskEntity task9 = new TaskEntity("Data cleaning and preprocessing", new Date(), cal.getTime(), employeeEntity1.getPk());
		TaskEntity task10 = new TaskEntity("Developing and maintaining data pipelines", new Date(), cal.getTime(), employeeEntity1.getPk());
		TaskEntity task11 = new TaskEntity("Debugging and testing code", new Date(), cal.getTime(), employeeEntity2.getPk());
		TaskEntity task12 = new TaskEntity("Reviewing and providing feedback on code", new Date(), cal.getTime(), employeeEntity2.getPk());
		TaskEntity task13 = new TaskEntity("Developing and implementing automated test scripts", new Date(), cal.getTime(), employeeEntity3.getPk());
		TaskEntity task14 = new TaskEntity("Investigating security incidents", new Date(), cal.getTime(), employeeEntity4.getPk());
		TaskEntity task15 = new TaskEntity("Creating wireframes and prototypes", new Date(), cal.getTime(), employeeEntity5.getPk());
		TaskEntity task16 = new TaskEntity("Creating design documentation", new Date(), cal.getTime(), employeeEntity5.getPk());
		taskRepository.saveAll(List.of(task1, task2, task3, task4, task5, task6, task7, task8, task9, task10, task11, task12, task13, task14, task15, task16));

		// Add reports
		cal.add(Calendar.DATE, -9);
		ReportEntity report1 = new ReportEntity("Data cleaning should be done today", cal.getTime(), employeeEntity1.getPk(), employeeEntity1.getManagerPk());
		ReportEntity report2 = new ReportEntity("Today we groomed the new project", cal.getTime(), managerEntity2.getPk(), managerEntity2.getManagerPk());
		ReportEntity report3 = new ReportEntity("Today we starting the planning of the new project", cal.getTime(), managerEntity3.getPk(), managerEntity3.getManagerPk());
		reportRepository.saveAll(List.of(report1, report2, report3));

	}
}
