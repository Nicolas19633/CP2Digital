package com.cp2.digitalapp.services;

import com.cp2.digitalapp.entities.Department;
import com.cp2.digitalapp.repositories.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(value = Transactional.TxType.NEVER)
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
    @Transactional(value = Transactional.TxType.NEVER)
    public void deleteDepartmentById(Long id){
        departmentRepository.deleteById(id);
    }
    public Department getDepartmentByName(String nome){
        return departmentRepository.findByNome(nome);
    }
}
