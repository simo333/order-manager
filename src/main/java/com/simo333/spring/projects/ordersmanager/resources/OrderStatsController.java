package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.OrderStats;
import com.simo333.spring.projects.ordersmanager.service.OrderStatsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrderStatsController {
    private final OrderStatsService service;

    public OrderStatsController(OrderStatsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderStats>> findAll() {
        List<OrderStats> ordersStats = service.findAllOrders();
        return new ResponseEntity<>(ordersStats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStats> findById(@PathVariable Long id) {
        OrderStats orderStats = service.getOne(id);
        return new ResponseEntity<>(orderStats, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderStats> add(@RequestBody @Valid OrderStats orderStats) {
        OrderStats newOrderStats = service.save(orderStats);
        return new ResponseEntity<>(newOrderStats, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStats> update(@PathVariable Long id, @RequestBody @Valid OrderStats orderStats) {
        orderStats.setId(id);
        OrderStats updated = service.update(orderStats);
        return new ResponseEntity<>(updated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
