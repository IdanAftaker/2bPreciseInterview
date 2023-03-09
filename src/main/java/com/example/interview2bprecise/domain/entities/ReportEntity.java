package com.example.interview2bprecise.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REPORTS")
public class ReportEntity implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;
}
