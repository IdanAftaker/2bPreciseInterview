package com.example.interview2bprecise.controllers;

import com.example.interview2bprecise.domain.dto.ReportDTO;
import com.example.interview2bprecise.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService service;

    @GetMapping("")
    List<ReportDTO> getAllReports() {
        return service.getAllReports();
    }
}
