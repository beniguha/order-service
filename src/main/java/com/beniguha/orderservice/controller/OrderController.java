package com.beniguha.orderservice.controller;

import com.beniguha.orderservice.dto.OrderRequest;
import com.beniguha.orderservice.entity.Order;
import com.beniguha.orderservice.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@Valid @RequestBody OrderRequest request) {
        return service.createOrder(request);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getByUser(@PathVariable Long userId) {
        return service.getOrdersByUser(userId);
    }
}