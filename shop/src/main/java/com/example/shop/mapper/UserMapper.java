package com.example.shop.mapper;

import com.example.shop.dto.UserDtO;
import com.example.shop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    UserDtO userToUserDtO(User user);

    @Mapping(target = "id", source = "userDtO.id")
    @Mapping(target = "username", source = "userDtO.username")
    User userDtOToUser(UserDtO userDtO);

}