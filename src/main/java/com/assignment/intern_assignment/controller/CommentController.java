package com.assignment.intern_assignment.controller;

import com.assignment.intern_assignment.dto.CommentCreateRequest;
import com.assignment.intern_assignment.entity.Comment;
import com.assignment.intern_assignment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long postId, @Valid @RequestBody CommentCreateRequest request) {
        Comment comment = commentService.addComment(postId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
}
