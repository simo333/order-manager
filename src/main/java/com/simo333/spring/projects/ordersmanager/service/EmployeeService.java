package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.EmployeeRepository;
import com.simo333.spring.projects.ordersmanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Page<Employee> findAllEmployeesInPages(Pageable page) {
        return repository.findAll(page);
    }

    public Employee findEmployeeById(Long id) {
        return repository.findEmployeeById(id);
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        repository.deleteEmployeeById(id);
    }
}
