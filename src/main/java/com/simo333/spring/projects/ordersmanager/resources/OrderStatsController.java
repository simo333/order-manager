package com.simo333.spring.projects.ordersmanager.resources;

import com.simo333.spring.projects.ordersmanager.model.OrderStats;
import com.simo333.spring.projects.ordersmanager.service.OrderStatsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<OrderStats>> all() {
        List<OrderStats> ordersStats = service.findAllOrders();
        return new ResponseEntity<>(ordersStats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStats> one(@PathVariable("id") Long id) {
        OrderStats orderStats = service.findOrderStatsById(id);
        return new ResponseEntity<>(orderStats, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderStats> addOrderStats(@RequestBody OrderStats orderStats) {
        OrderStats newOrderStats = service.addOrderStats(orderStats);
        return new ResponseEntity<>(newOrderStats, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStats> updateOrderStats(@RequestBody OrderStats orderStats, @PathVariable("id") Long id) {
        OrderStats newOrderStats = service.addOrderStats(orderStats);
        return new ResponseEntity<>(newOrderStats, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderStats(@PathVariable("id") Long id) {
        service.deleteOrderStats(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
