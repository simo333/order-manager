package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.FurnitureType;
import com.simo333.spring.projects.ordersmanager.service.FurnitureTypeService;
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
    ResponseEntity<List<FurnitureType>> findAll() {
        List<FurnitureType> types = service.findAllFurnitureTypes();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<FurnitureType> findById(@PathVariable("id") Long id) {
        FurnitureType actualFurnitureType = service.findFurnitureTypeById(id);
        return new ResponseEntity<>(actualFurnitureType, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<FurnitureType> add(@RequestBody FurnitureType type) {
        FurnitureType newFurnitureType = service.addFurnitureType(type);
        return new ResponseEntity<>(newFurnitureType, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<FurnitureType> update(@RequestBody FurnitureType type) {
        FurnitureType actualFurnitureType = service.updateFurnitureType(type);
        return new ResponseEntity<>(actualFurnitureType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.deleteFurnitureType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
