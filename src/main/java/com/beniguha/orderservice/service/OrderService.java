package com.beniguha.orderservice.service;

import com.beniguha.orderservice.dto.OrderRequest;
import com.beniguha.orderservice.entity.Order;
import com.beniguha.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());
        return repository.save(order);
    }

    public List<Order> getOrdersByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}