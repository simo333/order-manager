package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.JobPosition;
import com.simo333.spring.projects.ordersmanager.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/job-positions")
public class JobPositionController {

    private final JobPositionService service;

    @Autowired
    public JobPositionController(JobPositionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<JobPosition>> findAll() {
        List<JobPosition> jobPositionList = service.findAll();
        return new ResponseEntity<>(jobPositionList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> findById(@PathVariable Long id) {
        JobPosition actualJobPosition = service.getOne(id);
        return new ResponseEntity<>(actualJobPosition, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobPosition> add(@Valid @RequestBody JobPosition jobPosition) {
        JobPosition newJobPosition = service.save(jobPosition);
        return new ResponseEntity<>(newJobPosition, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosition> update(@PathVariable Long id, @RequestBody @Valid JobPosition jobPosition) {
        jobPosition.setId(id);
        JobPosition updated = service.update(jobPosition);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
