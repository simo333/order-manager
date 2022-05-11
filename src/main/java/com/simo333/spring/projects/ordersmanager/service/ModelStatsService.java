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

    public ModelStats findOneByModelId(Long id) {
        return repository.findModelStatsByModelId(id);
    }

    //TODO FIX this
    public ModelStats findOneByJobPositionId(Long id) {
        return repository.findModeStatsByJobPositionId(id);
    }

    public ModelStats updateModelStats(ModelStats modelStats) {
        return repository.save(modelStats);
    }

    @Transactional
    public void deleteOneById(Long id) {
        repository.deleteModelStatsByModelId(id);
    }

}
