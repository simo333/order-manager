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
        return repository.findOrderStatsById(id).orElseThrow();
    }


    public OrderStats addOrderStats(OrderStats orderStats) {
        return repository.save(orderStats);
    }

    @Transactional
    public OrderStats updateOrderStats(OrderStats orderStats) {
        OrderStats orderToEdit = repository.findOrderStatsById(orderStats.getId()).orElseThrow();
        orderToEdit.setDeadlineDate(orderStats.getDeadlineDate());
        orderToEdit.setDeliveryCity(orderStats.getDeliveryCity());
        orderToEdit.setDeliveryCountry(orderStats.getDeliveryCountry());
        orderToEdit.setDeliveryName(orderStats.getDeliveryName());
        orderToEdit.setDeliveryStreet(orderStats.getDeliveryStreet());
        orderToEdit.setDeliveryZip(orderStats.getDeliveryZip());
        return repository.save(orderStats);
    }

    @Transactional
    public void deleteOrderStats(Long id) {
        repository.deleteOrderStatsById(id);
    }
}
