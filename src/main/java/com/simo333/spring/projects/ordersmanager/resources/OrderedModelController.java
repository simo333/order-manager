package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.OrderedModel;
import com.simo333.spring.projects.ordersmanager.service.OrderedModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ordered-models")
public class OrderedModelController {
    private final OrderedModelService service;

    public OrderedModelController(OrderedModelService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderedModel>> findAll() {
        List<OrderedModel> orderedModels = service.findAll();
        return new ResponseEntity<>(orderedModels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderedModel> findByOrderedModelId(@PathVariable Long id) {
        OrderedModel orderedModel = service.getOne(id);
        return new ResponseEntity<>(orderedModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderedModel> add(@RequestBody @Valid OrderedModel orderedModel) {
        OrderedModel newOrderedModel = service.save(orderedModel);
        return new ResponseEntity<>(newOrderedModel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderedModel> update(@PathVariable Long id, @RequestBody @Valid OrderedModel orderedModel) {
        orderedModel.setId(id);
        OrderedModel updated = service.update(orderedModel);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
