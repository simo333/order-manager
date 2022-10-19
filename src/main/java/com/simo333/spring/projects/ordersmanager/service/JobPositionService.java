package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.repository.EmployeeRepository;
import com.simo333.spring.projects.ordersmanager.repository.JobPositionRepository;
import com.simo333.spring.projects.ordersmanager.repository.ModelWorkingStatsRepository;
import com.simo333.spring.projects.ordersmanager.model.JobPosition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class JobPositionService {

    private final JobPositionRepository repository;
    private final ModelWorkingStatsRepository modelWorkingStatsRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public JobPositionService(JobPositionRepository repository, ModelWorkingStatsRepository modelStatsRepo, EmployeeRepository employeeRepository) {
        this.repository = repository;
        this.modelWorkingStatsRepository = modelStatsRepo;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public JobPosition save(JobPosition jobPosition) {
        log.info("Saving job position: {}", jobPosition);
        return repository.save(jobPosition);
    }

    public List<JobPosition> findAll() {
        return repository.findAll();
    }

    public JobPosition getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("Job position with id '{}' not found.", id);
            throw new ResourceNotFoundException("Job position not found.");
        });
    }

    @Transactional
    public JobPosition update(JobPosition jobPosition) {
        getOne(jobPosition.getId());
        log.info("Updating job position with id '{}'", jobPosition.getId());
        return repository.save(jobPosition);
    }

    @Transactional
    public void deleteById(Long id) {
        if (modelWorkingStatsRepository.findAllByJobPositionId(id).isEmpty()
                && employeeRepository.findAllByJobPositionId(id).isEmpty()) {
            log.info("Deleting job position with id '{}'", id);
            repository.deleteById(id);
        }
    }
}
