package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.ModelStatsRepository;
import com.simo333.spring.projects.ordersmanager.model.ModelStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModelStatsService {
    private final ModelStatsRepository repository;

    @Autowired
    public ModelStatsService(ModelStatsRepository repository) {
        this.repository = repository;
    }

    public ModelStats addModelStats(ModelStats modelStats) {
        return repository.save(modelStats);
    }

    public List<ModelStats> findAllModelStats() {
        return repository.findAll();
    }

    public List<ModelStats> findAllByModelId(Long id) {
        return repository.findAllByModelId(id);
    }

    public List<ModelStats> findAllByJobPositionId(Long id) {
        return repository.findAllByJobPositionId(id);
    }

    public ModelStats findOneByModelIdAndJobPositionId(Long modelId, Long jobPositionId) {
        return repository.findModelStatsByModelIdAndJobPositionId(modelId, jobPositionId);
    }

    public ModelStats updateModelStats(ModelStats modelStats) {
        return repository.save(modelStats);
    }

    //TODO rewrite this method
    @Transactional
    public void deleteOneById(Long id) {
        repository.deleteModelStatsByModelId(id);
    }

}
