package com.example.shop.service;

import com.example.shop.dto.CommentDtO;
import com.example.shop.entity.Comment;
import com.example.shop.repository.UserRepository;
import com.example.shop.entity.User;
import com.example.shop.mapper.CommentMapper;
import com.example.shop.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentMapper commentMapper;

    public CommentDtO addComment(CommentDtO commentDTO) {
        Comment comment = commentMapper.commentDtOToComment(commentDTO);
        comment.setDate(LocalDateTime.now());
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.commentToCommentDtO(savedComment);
    }

    public List<CommentDtO> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return commentMapper.toDTOList(comments);
    }

    public List<CommentDtO> getCommentsByUserId(String username) {
        return commentRepository.findByAuthor(username).stream()
                .map(commentMapper::commentToCommentDtO)
                .collect(Collectors.toList());
    }

    public List<CommentDtO> getCommentsByOwner(String username) {
        return commentRepository.findByAuthor(username).stream()
                .map(commentMapper::commentToCommentDtO)
                .collect(Collectors.toList());
    }

    public List<CommentDtO> getCommentsByProductId(Long productId) {
        return commentRepository.findByProductId(productId).stream()
                .map(commentMapper::commentToCommentDtO)
                .collect(Collectors.toList());
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public Optional<CommentDtO> getCommentById(Long id) {
        return commentRepository.findById(id)
                .map(commentMapper::commentToCommentDtO);
    }
}