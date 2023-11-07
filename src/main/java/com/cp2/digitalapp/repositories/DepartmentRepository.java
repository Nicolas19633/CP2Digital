package com.cp2.digitalapp.repositories;

import com.cp2.digitalapp.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByNome(String nome);

}
