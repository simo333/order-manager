package com.simo333.spring.projects.ordersmanager.data;

import com.simo333.spring.projects.ordersmanager.model.MoneyRate;
import com.simo333.spring.projects.ordersmanager.model.MoneyRatePKId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRateRepository extends JpaRepository<MoneyRate, MoneyRatePKId> {
}
