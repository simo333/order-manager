package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.EmployeeRepository;
import com.simo333.spring.projects.ordersmanager.exception.ApiRequestException;
import com.simo333.spring.projects.ordersmanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
        return repository.findEmployeeById(id)
                .orElseThrow(() -> new ApiRequestException("Employee not found.", HttpStatus.NOT_FOUND));
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(Employee employee) {
        Employee employeeToEdit = findEmployeeById(employee.getId());
        employeeToEdit.setCity(employee.getCity());
        employeeToEdit.setContractBeginning(employee.getContractBeginning());
        employeeToEdit.setContractExpiration(employee.getContractExpiration());
        employeeToEdit.setCountry(employee.getCountry());
        employeeToEdit.setDateOfBirth(employee.getDateOfBirth());
        employeeToEdit.setLastName(employee.getLastName());
        employeeToEdit.setName(employee.getName());
        employeeToEdit.setPhoneNumber(employee.getPhoneNumber());
        employeeToEdit.setStreet(employee.getStreet());
        employeeToEdit.setZipCode(employee.getZipCode());
        employeeToEdit.setJobPosition(employee.getJobPosition());
        return repository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        repository.deleteEmployeeById(id);
    }
}
