package com.simo333.spring.projects.ordersmanager.model.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FurnitureTypeService {

    private final FurnitureTypeRepository repository;

    @Autowired
    public FurnitureTypeService(FurnitureTypeRepository repository) {
        this.repository = repository;
    }

    public FurnitureType addFurnitureType(FurnitureType type) {
        return repository.save(type);
    }

    public List<FurnitureType> findAllFurnitureTypes() {
        return repository.findAll();
    }

    public FurnitureType findFurnitureTypeById(Long id) {
        return repository.findFurnitureTypeById(id);
//                .orElseThrow(() -> new FurnitureTypeNotFoundException("Model by id " + id + " was not found!"));
    }

    public FurnitureType updateFurnitureType(FurnitureType type) {
        return repository.save(type);
    }

    @Transactional
    public void deleteFurnitureType(Long id) {
        repository.deleteFurnitureTypeById(id);
    }
}
