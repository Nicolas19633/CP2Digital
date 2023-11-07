package com.cp2.digitalapp.controller;

import com.cp2.digitalapp.entities.Employee;
import com.cp2.digitalapp.services.EmployeeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        employee.setEmployee_id(id);
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }
    @GetMapping("/salary")
    public ResponseEntity<List<Employee>> getEmployeeBySalary(@RequestParam double salario_inicial, @RequestParam double salario_final) {
        String hql = "FROM Employee WHERE salary BETWEEN :minSalary AND :maxSalary";
        Query query = entityManager.createQuery(hql);
        query.setParameter("minSalary", salario_inicial);
        query.setParameter("maxSalary", salario_final);
        List<Employee> employees = query.getResultList();
        return ResponseEntity.ok(employees);
    }
}
