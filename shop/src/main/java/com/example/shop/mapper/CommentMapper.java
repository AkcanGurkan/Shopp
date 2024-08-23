package com.example.shop.mapper;

import com.example.shop.dto.CommentDtO;
import com.example.shop.dto.ProductDtO;
import com.example.shop.entity.Comment;
import com.example.shop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDtO commentToCommentDtO(Comment comment);
    Comment commentDtOToComment(CommentDtO commentDtO);
    List<CommentDtO> toDTOList(List<Comment> comments);
    List<Comment> toEntityList(List<CommentDtO> commentDtOS);
}