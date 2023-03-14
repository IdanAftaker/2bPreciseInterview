package com.example.interview2bprecise.controllers;

import com.example.interview2bprecise.domain.dto.TaskDTO;
import com.example.interview2bprecise.domain.dto.TaskRequestDTO;
import com.example.interview2bprecise.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(@RequestParam("ownerPk")Optional<Long> ownerPk) {
        try {
            List<TaskDTO> tasks;
            if (ownerPk.isPresent()) {
                tasks = service.getTasksByOwnerPk(ownerPk.get());
            } else {
                tasks = service.getAllTasks();
            }
            if (tasks.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(tasks);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskRequestDTO requestDTO) {
        try {
            TaskDTO reportDTO = service.saveTask(requestDTO);
            return ResponseEntity.ok().body(reportDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
