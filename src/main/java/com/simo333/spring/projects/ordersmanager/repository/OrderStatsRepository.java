package com.simo333.spring.projects.ordersmanager.repository;

import com.simo333.spring.projects.ordersmanager.model.OrderStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatsRepository extends JpaRepository<OrderStats, Long> {
}
