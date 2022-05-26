package com.simo333.spring.projects.ordersmanager.data;

import com.simo333.spring.projects.ordersmanager.model.ModelStats;
import com.simo333.spring.projects.ordersmanager.model.ModelStatsPkId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModelStatsRepository extends JpaRepository<ModelStats, ModelStatsPkId> {

    List<ModelStats> findAllByModelId(Long id);

    List<ModelStats> findAllByJobPositionId(Long id);

    Optional<ModelStats> findModelStatsByModelIdAndJobPositionId(Long modelId, Long jobPositionId);

    void deleteOneByModelIdAndJobPositionId(Long modelId, Long jobPositionId);

    void deleteAllByJobPositionId(Long id);

    void deleteAllByModelId(Long id);
}
