package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.model.OrderedModel;
import com.simo333.spring.projects.ordersmanager.repository.OrderedModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class OrderedModelService {

    private final OrderedModelRepository repository;

    @Autowired
    public OrderedModelService(OrderedModelRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OrderedModel save(OrderedModel orderedModel) {
        log.info("Saving ordered model: {}", orderedModel);
        return repository.save(orderedModel);
    }

    public List<OrderedModel> findAll() {
        return repository.findAll();
    }

    public OrderedModel getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("Ordered model with id '{}' not found.", id);
            throw new ResourceNotFoundException("Model not found for given id");
        });
    }

    @Transactional
    public OrderedModel update(OrderedModel orderedModel) {
        getOne(orderedModel.getId());
        log.info("Updating ordered model with id '{}'", orderedModel.getId());
        return repository.save(orderedModel);
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting ordered model with id '{}'", id);
        repository.deleteById(id);
    }

}
