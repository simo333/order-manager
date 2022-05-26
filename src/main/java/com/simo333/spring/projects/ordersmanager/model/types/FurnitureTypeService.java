package com.simo333.spring.projects.ordersmanager.model.types;

import com.simo333.spring.projects.ordersmanager.data.ModelRepository;
import com.simo333.spring.projects.ordersmanager.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FurnitureTypeService {

    private final FurnitureTypeRepository repository;
    private final ModelRepository modelRepository;

    @Autowired
    public FurnitureTypeService(FurnitureTypeRepository repository, ModelRepository modelRepository) {
        this.repository = repository;
        this.modelRepository = modelRepository;
    }

    public FurnitureType addFurnitureType(FurnitureType type) {
        return repository.save(type);
    }

    public List<FurnitureType> findAllFurnitureTypes() {
        return repository.findAll();
    }

    public FurnitureType findFurnitureTypeById(Long id) {
        return repository.findFurnitureTypeById(id).orElseThrow(
                () -> new ApiRequestException("Furniture type for given id not found", HttpStatus.NOT_FOUND));
    }

    public FurnitureType updateFurnitureType(FurnitureType type) {
        FurnitureType typeToEdit = findFurnitureTypeById(type.getId());
        typeToEdit.setName(type.getName());
        return repository.save(type);
    }

    @Transactional
    public void deleteFurnitureType(Long id) {
        if(!modelRepository.findAllByTypeId(id).isEmpty()) {
            modelRepository.deleteAllByTypeId(id);
        }
        repository.deleteFurnitureTypeById(id);
    }
}
