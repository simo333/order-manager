package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.FurnitureType;
import com.simo333.spring.projects.ordersmanager.service.FurnitureTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        List<FurnitureType> types = service.findAll();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<FurnitureType> findById(@PathVariable Long id) {
        FurnitureType actualFurnitureType = service.getOne(id);
        return new ResponseEntity<>(actualFurnitureType, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<FurnitureType> add(@RequestBody @Valid FurnitureType type) {
        FurnitureType newFurnitureType = service.save(type);
        return new ResponseEntity<>(newFurnitureType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<FurnitureType> update(@PathVariable Long id, @RequestBody @Valid FurnitureType type) {
        type.setId(id);
        FurnitureType updated = service.update(type);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
