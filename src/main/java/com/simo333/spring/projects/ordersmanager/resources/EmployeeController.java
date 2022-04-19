package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.Employee;
import com.simo333.spring.projects.ordersmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> findAllEmployeesInPages(Pageable page) {
        Page<Employee> employees = service.findAllEmployeesInPages(page);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id) {
        Employee actualEmployee = service.findEmployeeById(id);
        if (actualEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actualEmployee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = service.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
        Employee actualEmployee = service.findEmployeeById(id);
        if(actualEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee.setId(id);
        actualEmployee = service.updateEmployee(employee);
        return new ResponseEntity<>(actualEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        Employee actualEmployee = service.findEmployeeById(id);
        if(actualEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
