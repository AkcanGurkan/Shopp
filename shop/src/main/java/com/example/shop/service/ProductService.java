package com.example.shop.service;

import com.example.shop.dto.ProductDtO;
import com.example.shop.dto.PurchaseResponseDtO;
import com.example.shop.entity.Product;
import com.example.shop.entity.User;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final UserService userService;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository, ProductMapper productMapper, UserService userService, UserRepository userRepository1) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.userService = userService;
        this.userRepository = userRepository1;
    }

    public List<ProductDtO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDTOList(products);
    }

    public Optional<ProductDtO> getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ExpressionException("Product not found with id: " + id));
        return Optional.of(productMapper.productToProductDto(product));
    }

    public List<ProductDtO> getProductByUsername(String username) {
        List<Product> products = productRepository.findAllByOwnerUsername(username);
        return productMapper.toDTOList(products);
    }

    public ProductDtO createProduct(ProductDtO productDTO) {
        Product product = productMapper.productDtOToProduct(productDTO);
        User currentUser = userService.getCurrentUser(product.getOwnerUsername());
        product.getUserProducts().add(currentUser);
        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductDto(savedProduct);
    }

    @Transactional
    public PurchaseResponseDtO purchaseProduct(Long productId, Long userId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı."));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı."));


        if (product.getStock() <= 0) {
            return new PurchaseResponseDtO("Ürün stokta yok.");
        }

        product.setStock(product.getStock() - 1);

        productRepository.save(product);
        userRepository.save(user);

        return new PurchaseResponseDtO("Ürün başarıyla satın alındı.");
    }

}