package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.repository.ModelRepository;
import com.simo333.spring.projects.ordersmanager.repository.ModelWorkingStatsRepository;
import com.simo333.spring.projects.ordersmanager.model.Model;
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
public class ModelService {

    private final ModelRepository repository;
    private final ModelWorkingStatsRepository modelWorkingStatsRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository, ModelWorkingStatsRepository modelWorkingStatsRepository) {
        this.repository = modelRepository;
        this.modelWorkingStatsRepository = modelWorkingStatsRepository;
    }

    public Page<Model> findAllModelsInPages(Pageable page) {
        log.info("Fetching Employees. {}", page);
        return repository.findAll(page);
    }

    public Model getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("Model with id '{}' not found.", id);
            throw new ResourceNotFoundException("Model not found. For id: " + id);
        });
    }

    @Transactional
    public Model save(Model model) {
        log.info("Saving model: {}", model);
        return repository.save(model);
    }

    @Transactional
    public Model update(Model model) {
        getOne(model.getId());
        log.info("Updating model with id '{}'", model.getId());
        return repository.save(model);
    }


    @Transactional
    public void deleteById(Long id) {
        if (!modelWorkingStatsRepository.existsByModelId(id)) {
            log.info("Deleting model with id '{}'", id);
            repository.deleteById(id);
        }
    }
}
