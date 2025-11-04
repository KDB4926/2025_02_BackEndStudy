package com.example.shop.order;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.net.URI;

@RestController
RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderCreateRequest request) {
        Long orderId = orderService.createOrder(request);
        return ResponseEntity.created(URI.create("/orders/" + orderId)).build();
    }

    @GetMapping
    public ResponseEntity<List<com.example.shop.order.Order>> getAllOrders() {

        List<com.example.shop.order.Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<java.lang.reflect.Order> getOrder(@PathVariable Long orderId) {
        java.lang.reflect.Order order = (Order) orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
