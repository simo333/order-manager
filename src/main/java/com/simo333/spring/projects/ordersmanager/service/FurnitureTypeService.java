package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.repository.FurnitureTypeRepository;
import com.simo333.spring.projects.ordersmanager.repository.ModelRepository;
import com.simo333.spring.projects.ordersmanager.model.FurnitureType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class FurnitureTypeService {

    private final FurnitureTypeRepository repository;
    private final ModelRepository modelRepository;

    @Autowired
    public FurnitureTypeService(FurnitureTypeRepository repository, ModelRepository modelRepository) {
        this.repository = repository;
        this.modelRepository = modelRepository;
    }

    @Transactional
    public FurnitureType save(FurnitureType type) {
        log.info("Saving furniture type: {}", type);
        return repository.save(type);
    }

    public List<FurnitureType> findAll() {
        return repository.findAll();
    }

    public FurnitureType getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("Furniture type with id '{}' not found.", id);
            throw new ResourceNotFoundException("Furniture type for given id not found");
        });
    }

    @Transactional
    public FurnitureType update(FurnitureType type) {
        getOne(type.getId());
        log.info("Updating furniture type with id '{}'", type.getId());
        return repository.save(type);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!modelRepository.findAllByTypeId(id).isEmpty()) {
            modelRepository.deleteAllByTypeId(id);
        }
        log.info("Deleting furniture type with id '{}'", id);
        repository.deleteById(id);
    }
}
