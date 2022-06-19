package com.simo333.spring.projects.ordersmanager.data;

import com.simo333.spring.projects.ordersmanager.model.OrderedModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderedModelRepository extends JpaRepository<OrderedModel, Long> {
    Optional<OrderedModel> findOrderedModelById(Long id);

    List<OrderedModel> findAllByOrderId(Long id);

    void deleteOrderedModelById(Long id);

    void deleteAllByOrderId(Long id);
}
