package com.simo333.spring.projects.ordersmanager.data;

import com.simo333.spring.projects.ordersmanager.model.ModelStats;
import com.simo333.spring.projects.ordersmanager.model.ModelStatsPkId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelStatsRepository extends JpaRepository<ModelStats, ModelStatsPkId> {

    List<ModelStats> findAllByModelId(Long id);

    List<ModelStats> findAllByJobPositionId(Long id);

    ModelStats findModelStatsByModelIdAndJobPositionId(Long modelId, Long jobPositionId);

    void deleteModelStatsByModelId(Long id);
}
