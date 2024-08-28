package com.example.shop.service;

import com.example.shop.dto.CartDtO;
import com.example.shop.entity.Cart;
import com.example.shop.mapper.CartMapper;
import com.example.shop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;


    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public CartDtO getCartByUserId(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        return cartMapper.cartToCartDto(cart);
    }

    public CartDtO saveCart(CartDtO cartDto) {
        Cart cart = cartMapper.cartDtoToCart(cartDto);
        Cart savedCart = cartRepository.save(cart);
        return cartMapper.cartToCartDto(savedCart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
