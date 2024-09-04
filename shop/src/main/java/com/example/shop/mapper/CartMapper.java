package com.example.shop.mapper;

import com.example.shop.dto.CartDtO;
import com.example.shop.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartDtO cartToCartDto(Cart cart);
    Cart cartDtoToCart(CartDtO cartDto);
}
