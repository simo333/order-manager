package com.simo333.spring.projects.ordersmanager.repository;

import com.simo333.spring.projects.ordersmanager.model.ModelWorkingStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModelWorkingStatsRepository extends JpaRepository<ModelWorkingStats, Long> {

    List<ModelWorkingStats> findAllByModelId(Long id);

    boolean existsByModelId(Long id);

    List<ModelWorkingStats> findAllByJobPositionId(Long id);

    Optional<ModelWorkingStats> findModelStatsByModelIdAndJobPositionId(Long modelId, Long jobPositionId);

    void deleteOneByModelIdAndJobPositionId(Long modelId, Long jobPositionId);

    void deleteAllByModelId(Long id);
}
