package com.example.shop.service;

import com.example.shop.dto.OrderPutRequestDtO;
import com.example.shop.dto.OrderRequestDtO;
import com.example.shop.dto.MessageResponseDtO;
import com.example.shop.dto.OrderResponseDtO;
import com.example.shop.entity.Order;
import com.example.shop.entity.Product;
import com.example.shop.entity.Status;
import com.example.shop.entity.User;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<OrderResponseDtO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> new OrderResponseDtO(
                        order.getId(),
                        order.getOrderDate(),
                        order.getUser().getId(),
                        (userRepository.findByUsername(order.getProduct().getOwnerUsername())).get().getId(),
                        order.getProduct().getId(),
                        order.getStatus().toString()
                ))
                .collect(Collectors.toList());
    }
    public List<OrderResponseDtO> getOrderHistory(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Order> orders = orderRepository.findByUser(user);

        return orders.stream()
                .map(order -> new OrderResponseDtO(
                        order.getId(),
                        order.getOrderDate(),
                        order.getUser().getId(),
                        (userRepository.findByUsername(order.getProduct().getOwnerUsername())).get().getId(),
                        order.getProduct().getId(),
                        order.getStatus().toString()
                ))
                .collect(Collectors.toList());
    }

    public List<OrderResponseDtO> getOrderHistorySeller(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Order> orders = orderRepository.findAllBySellerUsername(user.getUsername());

        return orders.stream()
                .map(order -> new OrderResponseDtO(
                        order.getId(),
                        order.getOrderDate(),
                        order.getUser().getId(),
                        (userRepository.findByUsername(order.getProduct().getOwnerUsername())).get().getId(),
                        order.getProduct().getId(),
                        order.getStatus().toString()
                ))
                .collect(Collectors.toList());
    }

    public MessageResponseDtO createOrder(Long userId, OrderRequestDtO orderRequestDtO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(orderRequestDtO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(Status.valueOf("WAITING"));
        orderRepository.save(order);
        String message = "Sipariş başarıyla oluşturuldu.";
        return new MessageResponseDtO(message);
    }

    @Transactional
    public MessageResponseDtO setOrderStatus(Long orderId, OrderPutRequestDtO orderPutRequestDtO){
        String message = "Bir hata oluştu.";

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Long productId = order.getProduct().getId();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        BigDecimal productPrice = product.getPrice();

        Long sellerId = orderPutRequestDtO.getUserId(); //kontrol yap.
        User sellerUser = userRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        BigDecimal sellerBalance = BigDecimal.valueOf(sellerUser.getWallet().getBalance());

        if (!sellerUser.getUsername().equals(product.getOwnerUsername())) {
            return new MessageResponseDtO(message);
        }

        Long customerId = order.getUser().getId();
        User customerUser = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        BigDecimal customerBalance = BigDecimal.valueOf(customerUser.getWallet().getBalance());

        if (Objects.equals(orderPutRequestDtO.getOrderStatus(), "ACCEPTED")){
            order.setStatus(Status.ACTIVE);
            BigDecimal newBalance = sellerBalance.add(productPrice);
            sellerUser.getWallet().setBalance(newBalance.doubleValue());
            message = "Sipariş başarıyla onaylandı.";
        } else if (Objects.equals(orderPutRequestDtO.getOrderStatus(), "CANCELLED")) {
            order.setStatus(Status.CANCELLED);
            product.setStock(product.getStock() + 1);
            BigDecimal newBalance = customerBalance.add(productPrice);
            customerUser.getWallet().setBalance(newBalance.doubleValue());
            message = "Sipariş başarıyla reddedildi.";
        }
        orderRepository.save(order);
        return new MessageResponseDtO(message);
    }
}