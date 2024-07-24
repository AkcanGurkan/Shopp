package com.example.shop.service;

import com.example.shop.model.Cart;
import com.example.shop.model.CartItem;
import com.example.shop.repository.CartRepository;
import com.example.shop.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void removeCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}