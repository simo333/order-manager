package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.ModelStatsRepository;
import com.simo333.spring.projects.ordersmanager.model.ModelStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelStatsService {
    private final ModelStatsRepository repository;

    @Autowired
    public ModelStatsService(ModelStatsRepository repository) {
        this.repository = repository;
    }

    public ModelStats addMoneyRate(ModelStats moneyRate) {
        return repository.save(moneyRate);
    }

    public List<ModelStats> findAllMoneyRate() {
        return repository.findAll();
    }

    public ModelStats findOneByModelId(Long id) {
        return repository.findModelStatsByModelId(id);
    }

    public ModelStats findOneByJobPositionId(Long id) {
        return repository.findModeStatsByJobPositionId(id);
    }




}
