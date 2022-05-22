package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.ModelRepository;
import com.simo333.spring.projects.ordersmanager.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Page<Model> findAllModelsInPages(Pageable page) {
        return modelRepository.findAll(page);
    }

    public Model findModelById(Long id) {
        return modelRepository.findModelById(id).orElseThrow();
    }

    public Model addModel(Model model) {
        return modelRepository.save(model);
    }

    public Model updateModel(Model model) {
        Model modelToEdit = modelRepository.findModelById(model.getId()).orElseThrow();
        modelToEdit.setName(model.getName());
        modelToEdit.setInnerName(model.getInnerName());
        modelToEdit.setType(model.getType());
        return modelRepository.save(model);
    }

    @Transactional
    public void deleteModel(Long id) {
        modelRepository.deleteModelById(id);
    }
}
