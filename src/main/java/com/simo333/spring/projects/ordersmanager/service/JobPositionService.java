package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.JobPositionRepository;
import com.simo333.spring.projects.ordersmanager.model.JobPosition;
import com.simo333.spring.projects.ordersmanager.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobPositionService {

    private final JobPositionRepository repository;

    @Autowired
    public JobPositionService(JobPositionRepository repository) {
        this.repository = repository;
    }

    public JobPosition addJobPosition(JobPosition jobPosition) {
        return repository.save(jobPosition);
    }

    public List<JobPosition> findAllJobPositions() {
        return repository.findAll();
    }

    public JobPosition findJobPositionById(Long id) {
        return repository.findJobPositionById(id);
//                .orElseThrow(() -> new ModelNotFoundException("Model by id " + id + " was not found!"));
    }

    public JobPosition updateJobPosition(JobPosition jobPosition) {
        return repository.save(jobPosition);
    }

    @Transactional
    public void deleteJobPositionById(Long id) {
        repository.deleteModelById(id);
    }
}
