package com.simo333.spring.projects.ordersmanager.service;

import com.simo333.spring.projects.ordersmanager.data.MoneyRateRepository;
import com.simo333.spring.projects.ordersmanager.model.MoneyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyRateService {
    private final MoneyRateRepository repository;

    @Autowired
    public MoneyRateService(MoneyRateRepository repository) {
        this.repository = repository;
    }

    public MoneyRate addMoneyRate(MoneyRate moneyRate) {
        return repository.save(moneyRate);
    }

    public List<MoneyRate> findAllMoneyRate() {
        return repository.findAll();
    }

}
