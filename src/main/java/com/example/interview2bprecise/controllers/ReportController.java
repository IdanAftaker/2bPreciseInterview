package com.example.interview2bprecise.controllers;

import com.example.interview2bprecise.domain.dto.ReportDTO;
import com.example.interview2bprecise.domain.dto.ReportRequestDTO;
import com.example.interview2bprecise.services.ReportService;
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
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService service;

    @GetMapping
    public ResponseEntity<List<ReportDTO>> getAllReports(@RequestParam("ownerPk") Optional<Long> ownerPk) {
        try {
            List<ReportDTO> reports;
            if (ownerPk.isPresent()) {
                reports = service.getReportsByOwnerPk(ownerPk.get());
            } else {
                reports = service.getAllReports();
            }
            if (reports.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(reports);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ReportDTO> saveReport(@RequestBody ReportRequestDTO requestDTO) {
        try {
            ReportDTO reportDTO = service.saveReport(requestDTO);
            return ResponseEntity.ok().body(reportDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
