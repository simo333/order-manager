package com.simo333.spring.projects.ordersmanager.data;

import com.simo333.spring.projects.ordersmanager.model.OrderedModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderedModelRepository extends JpaRepository<OrderedModel, Long> {
    Optional<OrderedModel> findOrderedModelById(Long id);

    void deleteOrderedModelById(Long id);

}
