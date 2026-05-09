package com.assignment.intern_assignment.controller;

import com.assignment.intern_assignment.dto.LikeRequest;
import com.assignment.intern_assignment.dto.PostCreateRequest;
import com.assignment.intern_assignment.entity.Post;
import com.assignment.intern_assignment.service.PostService;
import com.assignment.intern_assignment.service.RedisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final RedisService redisService;

    @PostMapping
    public ResponseEntity<Post> createPost(@Valid @RequestBody PostCreateRequest request){
        Post post = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<Post> likePost(@PathVariable Long postId ,
                                         @Valid @RequestBody LikeRequest request){
        postService.likePost(postId , request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{postId}/virality")
    public ResponseEntity<Integer> getViralityScore(@PathVariable Long postId) {
        return ResponseEntity.ok(redisService.getViralityScore(postId));
    }
}
