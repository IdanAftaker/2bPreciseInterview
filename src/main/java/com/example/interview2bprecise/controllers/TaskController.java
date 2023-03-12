package com.example.interview2bprecise.controllers;

import com.example.interview2bprecise.domain.dto.TaskDTO;
import com.example.interview2bprecise.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping("")
    public List<TaskDTO> getAllTasks(@RequestParam("ownerPk")Optional<Long> ownerPk) {
        if (ownerPk.isPresent()) {
            return service.getTasksByOwnerPk(ownerPk.get());
        }
        return service.getAllTasks();
    }
}
