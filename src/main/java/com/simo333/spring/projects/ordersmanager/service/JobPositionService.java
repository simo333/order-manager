package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.EmployeeRepository;
import com.simo333.spring.projects.ordersmanager.data.JobPositionRepository;
import com.simo333.spring.projects.ordersmanager.data.ModelStatsRepository;
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
    private final ModelStatsRepository modelStatsRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public JobPositionService(JobPositionRepository repository, ModelStatsRepository modelStatsRepo, EmployeeRepository employeeRepository) {
        this.repository = repository;
        this.modelStatsRepository = modelStatsRepo;
        this.employeeRepository = employeeRepository;
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
        if (!modelStatsRepository.findAllByJobPositionId(id).isEmpty()) {
            modelStatsRepository.deleteAllByJobPositionId(id);
        }
        if (!employeeRepository.findAllByJobPositionId(id).isEmpty()) {
            employeeRepository.deleteAllByJobPositionId(id);
        }
        repository.deleteJobPositionById(id);
    }
}
