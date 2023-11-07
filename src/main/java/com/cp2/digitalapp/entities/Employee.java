package com.cp2.digitalapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Long employee_id;
    private String nome;
    private String title;
    private double salary;
    private String manager;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department_id;
}
