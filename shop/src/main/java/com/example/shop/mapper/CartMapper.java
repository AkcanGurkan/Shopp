package com.example.shop.mapper;

import com.example.shop.dto.CartDtO;
import com.example.shop.dto.CartItemDtO;
import com.example.shop.entity.Cart;
import com.example.shop.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDtO cartToCartDto(Cart cart);
    Cart cartDtoToCart(CartDtO cartDto);
    CartItemDtO cartItemToCartItemDto(CartItem cartItem);
    CartItem cartItemDtoToCartItem(CartItemDtO cartItemDto);
}
