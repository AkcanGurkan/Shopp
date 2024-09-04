package com.example.shop.mapper;

import com.example.shop.dto.UserDtO;
import com.example.shop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDtO userToUserDtO(User user);
    User userDtOToUser(UserDtO userDtO);
    List<UserDtO> toDTOList(List<User> users);
}