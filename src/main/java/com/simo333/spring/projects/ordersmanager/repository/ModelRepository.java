package com.simo333.spring.projects.ordersmanager.repository;

import com.simo333.spring.projects.ordersmanager.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findAllByTypeId(Long id);

    void deleteAllByTypeId(Long id);
}
