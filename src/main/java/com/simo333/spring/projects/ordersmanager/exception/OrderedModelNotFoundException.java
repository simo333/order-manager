package com.simo333.spring.projects.ordersmanager.exception;

public class OrderedModelNotFoundException extends RuntimeException {
    public OrderedModelNotFoundException(String message) {
        super(message);
    }
}
