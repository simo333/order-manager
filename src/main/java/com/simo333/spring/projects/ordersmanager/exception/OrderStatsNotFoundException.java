package com.simo333.spring.projects.ordersmanager.exception;

public class OrderStatsNotFoundException extends RuntimeException {
    public OrderStatsNotFoundException(String message) {
        super(message);
    }
}
