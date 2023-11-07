package com.cp2.digitalapp.services;

import com.cp2.digitalapp.entities.Employee;
import com.cp2.digitalapp.repositories.DepartmentRepository;
import com.cp2.digitalapp.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Transactional(value = Transactional.TxType.NEVER)
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    @Transactional(value = Transactional.TxType.NEVER)
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

}
