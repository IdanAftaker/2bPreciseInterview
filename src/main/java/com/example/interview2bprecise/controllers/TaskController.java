package com.example.interview2bprecise.controllers;

import com.example.interview2bprecise.domain.dto.TaskDTO;
import com.example.interview2bprecise.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping("")
    public List<TaskDTO> getAllTasks() {
        return service.getAllTasks();
    }
}
