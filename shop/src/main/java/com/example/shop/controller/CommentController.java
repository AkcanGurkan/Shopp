package com.example.shop.controller;

import com.example.shop.dto.CommentDtO;
import com.example.shop.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@Tag(name = "Comment Management System", description = "Operations pertaining to comment in Comment Management System")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Operation(summary = "Add a new comment")
    @PostMapping
    public CommentDtO addComment(@RequestBody CommentDtO commentDTO) {
        return commentService.addComment(commentDTO);
    }

    @Operation(summary = "View a list of all comments")
    @GetMapping
    public List<CommentDtO> getAllComments() {
        return commentService.getAllComments();
    }

    @Operation(summary = "Get comments by product ID")
    @GetMapping("/product/{productId}")
    public List<CommentDtO> getCommentsByProductId(@PathVariable Long productId) {
        return commentService.getCommentsByProductId(productId);
    }

    @Operation(summary = "Get comments by author ID")
    @GetMapping("/author/{username}")
    public List<CommentDtO> getCommentsByUserId(@PathVariable String username) {
        return commentService.getCommentsByUserId(username);
    }

    @Operation(summary = "Delete a comment by ID")
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @Operation(summary = "Get a comment by ID")
    @GetMapping("/{id}")
    public Optional<CommentDtO> getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }
}