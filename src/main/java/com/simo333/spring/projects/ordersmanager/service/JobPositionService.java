package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.JobPositionRepository;
import com.simo333.spring.projects.ordersmanager.exception.ApiRequestException;
import com.simo333.spring.projects.ordersmanager.model.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return repository.findJobPositionById(id)
                .orElseThrow(() -> new ApiRequestException("Job position not found.", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public JobPosition updateJobPosition(JobPosition jobPosition) {
        JobPosition jobPositionToEdit = findJobPositionById(jobPosition.getId());
        jobPositionToEdit.setName(jobPosition.getName());
        return repository.save(jobPosition);
    }

    @Transactional
    public void deleteJobPositionById(Long id) {
        repository.deleteJobPositionById(id);
    }
}
