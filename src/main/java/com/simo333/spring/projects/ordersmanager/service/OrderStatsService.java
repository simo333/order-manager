package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.model.OrderStats;
import com.simo333.spring.projects.ordersmanager.repository.OrderStatsRepository;
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
public class OrderStatsService {
    private final OrderStatsRepository repository;
    private final OrderedModelRepository orderedModelRepository;

    @Autowired
    public OrderStatsService(OrderStatsRepository repository, OrderedModelRepository orderedModelRepository) {
        this.repository = repository;
        this.orderedModelRepository = orderedModelRepository;
    }

    public List<OrderStats> findAllOrders() {
        return repository.findAll();
    }

    public OrderStats getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("Order with id '{}' not found.", id);
            throw new ResourceNotFoundException("Order not found for given id");
        });
    }

    @Transactional
    public OrderStats save(OrderStats orderStats) {
        log.info("Saving a new order: {}", orderStats);
        return repository.save(orderStats);
    }

    @Transactional
    public OrderStats update(OrderStats orderStats) {
        getOne(orderStats.getId());
        log.info("Updating order with id '{}'", orderStats.getId());
        return repository.save(orderStats);
    }

    @Transactional
    public void deleteById(Long id) {
        orderedModelRepository.deleteAllByOrderId(id);
        log.info("Deleting order with id '{}' with all ordered models", id);
        repository.deleteById(id);
    }
}
