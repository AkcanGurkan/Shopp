package com.example.shop.mapper;

import com.example.shop.dto.CommentDtO;
import com.example.shop.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDtO commentToCommentDtO(Comment comment);

    Comment commentDtOToComment(CommentDtO commentDtO);
}