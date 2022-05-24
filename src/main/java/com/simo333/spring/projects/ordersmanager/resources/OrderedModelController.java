package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.OrderedModel;
import com.simo333.spring.projects.ordersmanager.service.OrderedModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<OrderedModel> orderedModels = service.findAllOrderedModels();
        return new ResponseEntity<>(orderedModels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderedModel> findByOrderedModelId(@PathVariable("id") Long id) {
        OrderedModel orderedModel = service.findOrderedModelById(id);
        return new ResponseEntity<>(orderedModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderedModel> add(@RequestBody OrderedModel orderedModel) {
        OrderedModel newOrderedModel = service.addOrderedModel(orderedModel);
        return new ResponseEntity<>(newOrderedModel, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderedModel> update(@RequestBody OrderedModel orderedModel) {
        OrderedModel newOrderedModel = service.updateOrderedModel(orderedModel);
        return new ResponseEntity<>(newOrderedModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.deleteOrderedModel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
