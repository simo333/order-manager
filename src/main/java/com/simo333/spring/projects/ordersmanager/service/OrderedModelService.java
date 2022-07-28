package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.OrderStatsRepository;
import com.simo333.spring.projects.ordersmanager.data.OrderedModelRepository;
import com.simo333.spring.projects.ordersmanager.exception.ApiRequestException;
import com.simo333.spring.projects.ordersmanager.model.OrderStats;
import com.simo333.spring.projects.ordersmanager.model.OrderedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
public class OrderedModelService {

    private final OrderedModelRepository repository;
    private final OrderStatsRepository orderRepository;

    @Autowired
    public OrderedModelService(OrderedModelRepository repository, OrderStatsRepository orderRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }

    public OrderedModel addOrderedModel(@Valid OrderedModel orderedModel) {
        orderRepository.findOrderStatsById(orderedModel.getOrder().getId())
                .orElseThrow(() -> new ApiRequestException("Order of given id does not exist", HttpStatus.NOT_FOUND));
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
