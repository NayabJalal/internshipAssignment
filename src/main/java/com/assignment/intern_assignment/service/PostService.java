package com.assignment.intern_assignment.service;

import com.assignment.intern_assignment.dto.LikeRequest;
import com.assignment.intern_assignment.dto.PostCreateRequest;
import com.assignment.intern_assignment.entity.Post;
import com.assignment.intern_assignment.repository.BotRepository;
import com.assignment.intern_assignment.repository.PostRepository;
import com.assignment.intern_assignment.repository.UserRepository;
import com.assignment.intern_assignment.validator.PostValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService implements IPostService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final BotRepository botRepository;
    private final PostValidator postValidator;
    private final RedisService redisService;

    @Override
    public Post createPost(PostCreateRequest request) {
        postValidator.validateCreateRequest(request);

        if ("USER".equalsIgnoreCase(request.getAuthorType())){
            userRepository.findById(request.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("User not found !! "));
        }else {
            botRepository.findById(request.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("Bot not found !! "));
        }

        Post post = Post.builder()
                .content(request.getContent())
                .authorId(request.getAuthorId())
                .authorType(Post.AuthorType.valueOf(request.getAuthorType().toUpperCase()))
                .build();
        return postRepository.save(post);
    }

    @Override
    public void likePost(Long postId, LikeRequest request) {
        log.info("🔵 LikePost called for postId: {}, userId: {}", postId, request.getUserId());
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found !! "));

        userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found !! "));

        //For human - 20+ points---
        log.info("✅ About to increment virality score for post {}", postId);
        redisService.incrementViralityScore(postId, 20);
        log.info("🎉 Virality score incremented successfully");
    }
}
