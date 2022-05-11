package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.MoneyStatsRepository;
import com.simo333.spring.projects.ordersmanager.model.ModelStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyStatsService {
    private final MoneyStatsRepository repository;

    @Autowired
    public MoneyStatsService(MoneyStatsRepository repository) {
        this.repository = repository;
    }

    public ModelStats addMoneyRate(ModelStats moneyRate) {
        return repository.save(moneyRate);
    }

    public List<ModelStats> findAllMoneyRate() {
        return repository.findAll();
    }

}
