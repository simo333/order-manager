package com.simo333.spring.projects.ordersmanager.data;

import com.simo333.spring.projects.ordersmanager.model.OrderStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderStatsRepository extends JpaRepository<OrderStats, Long> {
    Optional<OrderStats> findOrderStatsById(Long id);

    void deleteOrderStatsById(Long id);

}
