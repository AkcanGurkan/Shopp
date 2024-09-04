package com.example.shop.controller;

import com.example.shop.dto.OrderPutRequestDtO;
import com.example.shop.dto.OrderRequestDtO;
import com.example.shop.dto.MessageResponseDtO;
import com.example.shop.dto.OrderResponseDtO;
import com.example.shop.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDtO>> getAllOrders() {
        List<OrderResponseDtO> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/orders/{userId}")
    public ResponseEntity<List<OrderResponseDtO>> getOrderHistory(@PathVariable Long userId) {
        List<OrderResponseDtO> orderHistory = orderService.getOrderHistory(userId);
        return ResponseEntity.ok(orderHistory);
    }

    @GetMapping("/orders/seller/{userId}")
    public ResponseEntity<List<OrderResponseDtO>> getOrderHistorySeller(@PathVariable Long userId) {
        List<OrderResponseDtO> orderHistory = orderService.getOrderHistorySeller(userId);
        return ResponseEntity.ok(orderHistory);
    }

    @PostMapping("/customer/orders/{userId}")
    public MessageResponseDtO createOrder(@PathVariable Long userId, @RequestBody OrderRequestDtO orderRequestDtO) {
        return orderService.createOrder(userId, orderRequestDtO);
    }

    @PutMapping("/customer/orders/{orderId}")
    public MessageResponseDtO setOrderStatus(@PathVariable Long orderId, @RequestBody OrderPutRequestDtO orderPutRequestDtO){
        return orderService.setOrderStatus(orderId, orderPutRequestDtO);
    }
}