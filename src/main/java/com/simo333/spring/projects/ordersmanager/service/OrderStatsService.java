package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.OrderStatsRepository;
import com.simo333.spring.projects.ordersmanager.exception.OrderStatsNotFoundException;
import com.simo333.spring.projects.ordersmanager.model.OrderStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderStatsService {
    private final OrderStatsRepository repository;

    @Autowired
    public OrderStatsService(OrderStatsRepository repository) {
        this.repository = repository;
    }

    public List<OrderStats> findAllOrders() {
        return repository.findAll();
    }

    public OrderStats findOrderStatsById(Long id) {
        return repository.findOrderStatsById(id).orElseThrow(
                () -> new OrderStatsNotFoundException("Order by id " + id + " was not found!"));
    }


    public OrderStats addOrderStats(OrderStats orderStats) {
        return repository.save(orderStats);
    }

    public OrderStats updateOrderStats(OrderStats orderStats) {
        return repository.save(orderStats);
    }

    @Transactional
    public void deleteOrderStats(Long id) {
        repository.deleteOrderStatsById(id);
    }
}
