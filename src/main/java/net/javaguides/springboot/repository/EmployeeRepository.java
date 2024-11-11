package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, Long>{

}
