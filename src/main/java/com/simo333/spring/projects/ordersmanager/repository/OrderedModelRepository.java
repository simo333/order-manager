package com.simo333.spring.projects.ordersmanager.repository;

import com.simo333.spring.projects.ordersmanager.model.OrderedModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedModelRepository extends JpaRepository<OrderedModel, Long> {
    List<OrderedModel> findAllByOrderId(Long id);

    void deleteAllByOrderId(Long id);
}
