package com.example.shop.mapper;

import com.example.shop.dto.ProductDtO;
import com.example.shop.dto.UserDtO;
import com.example.shop.entity.Product;
import com.example.shop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDtO productToProductDto(Product product);
    Product productDtOToProduct(ProductDtO productDtO);

    List<ProductDtO> toDTOList(List<Product> products);
    List<Product> toEntityList(List<ProductDtO> productDtOS);
}
