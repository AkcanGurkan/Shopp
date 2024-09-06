package com.example.shop.service;

import com.example.shop.dto.AddToCartDto;
import com.example.shop.dto.CartDtO;
import com.example.shop.entity.Cart;
import com.example.shop.entity.CartItem;
import com.example.shop.entity.Product;
import com.example.shop.entity.User;
import com.example.shop.mapper.CartMapper;
import com.example.shop.repository.CartRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public CartDtO getCartByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Cart cart = cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        return cartMapper.cartToCartDto(cart);
    }

    public CartDtO saveCart(CartDtO cartDto) {
        Cart cart = cartMapper.cartDtoToCart(cartDto);
        Cart savedCart = cartRepository.save(cart);
        return cartMapper.cartToCartDto(savedCart);
    }

    public void deleteCart(Long id) {
        if (!cartRepository.existsById(id)) {
            throw new RuntimeException("Cart not found with id: " + id);
        }
        cartRepository.deleteById(id);
    }

    public CartDtO addItemToCart(AddToCartDto addToCartDto) {
        User user = userRepository.findById(addToCartDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return newCart;
                });

        Product product = productRepository.findById(addToCartDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProductName().equals(product.getName()))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + addToCartDto.getQuantity());
        } else {
            CartItem newItem = new CartItem();
            newItem.setProductId(product.getId());
            newItem.setProductName(product.getName());
            newItem.setQuantity(addToCartDto.getQuantity());
            newItem.setPrice(product.getPrice().doubleValue());
            newItem.setCart(cart);
            cart.getItems().add(newItem);
        }

        Cart updatedCart = cartRepository.save(cart);
        return cartMapper.cartToCartDto(updatedCart);
    }

    @Transactional
    public CartDtO updateCartItemQuantity(Long userId, Long productId, int quantity) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartItem itemToUpdate = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found in cart"));

        itemToUpdate.setQuantity(quantity);

        if (quantity <= 0) {
            cart.getItems().remove(itemToUpdate);
        }

        Cart updatedCart = cartRepository.save(cart);
        return cartMapper.cartToCartDto(updatedCart);
    }

    @Transactional
    public CartDtO removeFromCart(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        cart.getItems().removeIf(item -> item.getProductId().equals(productId));

        Cart updatedCart = cartRepository.save(cart);
        return cartMapper.cartToCartDto(updatedCart);
    }
}
