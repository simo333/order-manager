package com.simo333.spring.projects.ordersmanager.data;

import com.simo333.spring.projects.ordersmanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeById(Long id);

    void deleteEmployeeById(Long id);

    List<Employee> findAllByJobPositionId(Long id);

    void deleteAllByJobPositionId(Long id);
}
