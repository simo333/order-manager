package com.simo333.spring.projects.ordersmanager.data;

import com.simo333.spring.projects.ordersmanager.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
    //        Optional<Model> findModelById(Long id);
    Model findModelById(Long id);

    void deleteModelById(Long id);

}
