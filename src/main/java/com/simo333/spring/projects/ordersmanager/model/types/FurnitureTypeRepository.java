package com.simo333.spring.projects.ordersmanager.model.types;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureTypeRepository extends JpaRepository<FurnitureType, Long> {
    //    Optional<FurnitureType> findFurnitureTypeById(Long id);
    FurnitureType findFurnitureTypeById(Long id);

    void deleteFurnitureTypeById(Long id);
}
