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
@RequestMapping("/api")
@Tag(name = "Comment Management System", description = "Operations pertaining to comment in Comment Management System")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Operation(summary = "Add a new comment")
    @PostMapping("/customer/comments")
    public CommentDtO addComment(@RequestBody CommentDtO commentDTO) {
        return commentService.addComment(commentDTO);
    }

    @Operation(summary = "View a list of all comments")
    @GetMapping("/comments")
    public List<CommentDtO> getAllComments() {
        return commentService.getAllComments();
    }

    @Operation(summary = "Get comments by product ID")
    @GetMapping("/comments/product/{productId}")
    public List<CommentDtO> getCommentsByProductId(@PathVariable Long productId) {
        return commentService.getCommentsByProductId(productId);
    }

    @Operation(summary = "Get comments by author ID")
    @GetMapping("/comments/author/{username}")
    public List<CommentDtO> getCommentsByUserId(@PathVariable String username) {
        return commentService.getCommentsByUserId(username);
    }

    @Operation(summary = "Get comments by product owner username")
    @GetMapping("/comments/owner/{username}")
    public List<CommentDtO> getCommentsByOwner(@PathVariable String username) {
        return commentService.getCommentsByOwner(username);
    }

    @Operation(summary = "Delete a comment by ID")
    @DeleteMapping("/comments/admin/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @Operation(summary = "Get a comment by ID")
    @GetMapping("/comments/{id}")
    public Optional<CommentDtO> getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }
}