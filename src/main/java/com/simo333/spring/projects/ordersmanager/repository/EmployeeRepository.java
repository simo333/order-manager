package com.simo333.spring.projects.ordersmanager.repository;

import com.simo333.spring.projects.ordersmanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByJobPositionId(Long id);

    void deleteAllByJobPositionId(Long id);
}
