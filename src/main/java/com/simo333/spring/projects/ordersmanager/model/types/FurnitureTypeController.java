package com.simo333.spring.projects.ordersmanager.model.types;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/furniture-types")
public class FurnitureTypeController {

    private final FurnitureTypeService service;

    public FurnitureTypeController(FurnitureTypeService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<FurnitureType>> findAllTypes() {
        List<FurnitureType> types = service.findAllFurnitureTypes();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<FurnitureType> findTypeById(@PathVariable("id") Long id) {
        FurnitureType actualFurnitureType = service.findFurnitureTypeById(id);
        if (actualFurnitureType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actualFurnitureType, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<FurnitureType> newType(@RequestBody FurnitureType type) {
        FurnitureType newFurnitureType = service.addFurnitureType(type);
        return new ResponseEntity<>(newFurnitureType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<FurnitureType> updateType(@RequestBody FurnitureType type, @PathVariable("id") Long id) {
        FurnitureType actualFurnitureType = service.findFurnitureTypeById(id);
        if (actualFurnitureType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actualFurnitureType.setId(id);
        actualFurnitureType = service.updateFurnitureType(type);
        return new ResponseEntity<>(actualFurnitureType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteType(@PathVariable("id") Long id) {
        if (service.findFurnitureTypeById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteFurnitureType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
