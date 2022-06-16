package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.ModelRepository;
import com.simo333.spring.projects.ordersmanager.data.ModelStatsRepository;
import com.simo333.spring.projects.ordersmanager.exception.ApiRequestException;
import com.simo333.spring.projects.ordersmanager.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModelService {

    private final ModelRepository repository;
    private final ModelStatsRepository modelStatsRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository, ModelStatsRepository modelStatsRepository) {
        this.repository = modelRepository;
        this.modelStatsRepository = modelStatsRepository;
    }

    public Page<Model> findAllModelsInPages(Pageable page) {
        return repository.findAll(page);
    }

    public Model findModelById(Long id) {
        return repository.findModelById(id)
                .orElseThrow(() -> new ApiRequestException("Model not found.", HttpStatus.NOT_FOUND));
    }

    public Model addModel(Model model) {
        return repository.save(model);
    }

    @Transactional
    public Model updateModel(Model model) {
        Model modelToEdit = findModelById(model.getId());
        modelToEdit.setName(model.getName());
        modelToEdit.setInnerName(model.getInnerName());
        modelToEdit.setType(model.getType());
        return repository.save(model);
    }


    //TODO decide whether to delete ordered models and orders while deleting models or not
    @Transactional
    public void deleteModel(Long id) {
        if (!modelStatsRepository.findAllByModelId(id).isEmpty()) {
            modelStatsRepository.deleteAllByModelId(id);
        }
        repository.deleteModelById(id);
    }
}
