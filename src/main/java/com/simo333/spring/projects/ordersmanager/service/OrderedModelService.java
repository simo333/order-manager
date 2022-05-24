package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.OrderedModelRepository;
import com.simo333.spring.projects.ordersmanager.exception.ApiRequestException;
import com.simo333.spring.projects.ordersmanager.model.OrderedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderedModelService {

    private final OrderedModelRepository repository;

    @Autowired
    public OrderedModelService(OrderedModelRepository repository) {
        this.repository = repository;
    }

    public OrderedModel addOrderedModel(OrderedModel orderedModel) {
        return repository.save(orderedModel);
    }

    public List<OrderedModel> findAllOrderedModels() {
        return repository.findAll();
    }

    public OrderedModel findOrderedModelById(Long id) {
        return repository.findOrderedModelById(id)
                .orElseThrow(() -> new ApiRequestException("Model not found for given id", HttpStatus.NOT_FOUND));
    }

    @Transactional
    public OrderedModel updateOrderedModel(OrderedModel orderedModel) {
        OrderedModel orderedModelToEdit = findOrderedModelById(orderedModel.getId());
        orderedModelToEdit.setModel(orderedModel.getModel());
        orderedModelToEdit.setMaterial(orderedModel.getMaterial());
        orderedModelToEdit.setSpecialDesign(orderedModel.getSpecialDesign());
        return repository.save(orderedModel);
    }

    @Transactional
    public void deleteOrderedModel(Long id) {
        repository.deleteOrderedModelById(id);
    }

}
