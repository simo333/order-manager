package com.simo333.spring.projects.ordersmanager.data;

import com.simo333.spring.projects.ordersmanager.model.ModelStats;
import com.simo333.spring.projects.ordersmanager.model.MoneyRatePKId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelStatsRepository extends JpaRepository<ModelStats, MoneyRatePKId> {
    ModelStats findModelStatsByModelId(Long id);

    ModelStats findModeStatsByJobPositionId(Long id);
}
