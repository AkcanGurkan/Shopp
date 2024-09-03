package com.example.shop.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.example.shop.dto.UserDtO;
import com.example.shop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring") // bütün mapperlara eklenmesi gerek.
public interface UserMapper {

    UserDtO userToUserDtO(User user);
    User userDtOToUser(UserDtO userDtO);
    List<UserDtO> toDTOList(List<User> users);
    List<User> toEntityList(List<UserDtO> userDtOs);
}