package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.repository.EmployeeRepository;
import com.simo333.spring.projects.ordersmanager.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Page<Employee> findAllEmployeesInPages(Pageable page) {
        log.info("Fetching Employees. {}", page);
        return repository.findAll(page);
    }

    public Employee getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("Employee with id '{}' not found.", id);
            throw new ResourceNotFoundException("Employee not found. For id: " + id);
        });
    }

    @Transactional
    public Employee save(Employee employee) {
        log.info("Saving employee: {}", employee);
        return repository.save(employee);
    }

    @Transactional
    public Employee update(Employee employee) {
        getOne(employee.getId());
        log.info("Updating employee with id '{}'", employee.getId());
        return repository.save(employee);
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting employee with id '{}'", id);
        repository.deleteById(id);
    }
}
