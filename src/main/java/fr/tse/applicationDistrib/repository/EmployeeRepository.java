package fr.tse.applicationDistrib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tse.applicationDistrib.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findAllByOrderBySalaryAsc();

}
