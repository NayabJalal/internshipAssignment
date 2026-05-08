package com.assignment.intern_assignment.controller;

import com.assignment.intern_assignment.dto.PostCreateRequest;
import com.assignment.intern_assignment.entity.Post;
import com.assignment.intern_assignment.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@Valid @RequestBody PostCreateRequest request){
        Post post = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
}
