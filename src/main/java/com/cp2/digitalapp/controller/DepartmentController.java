package com.cp2.digitalapp.controller;

import com.cp2.digitalapp.entities.Department;
import com.cp2.digitalapp.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }
    @GetMapping("/nome/{name}")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable String name){
        return ResponseEntity.ok(departmentService.getDepartmentByName(name));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable Long id){
        department.setDepartment_id(id);
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }
    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department){
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }


}
