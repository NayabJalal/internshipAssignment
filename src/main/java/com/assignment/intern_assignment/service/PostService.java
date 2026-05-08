package com.assignment.intern_assignment.service;

import com.assignment.intern_assignment.dto.PostCreateRequest;
import com.assignment.intern_assignment.entity.Post;
import com.assignment.intern_assignment.repository.BotRepository;
import com.assignment.intern_assignment.repository.PostRepository;
import com.assignment.intern_assignment.repository.UserRepository;
import com.assignment.intern_assignment.validator.PostValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final BotRepository botRepository;
    private final PostValidator postValidator;

    @Override
    public Post createPost(PostCreateRequest request) {
        postValidator.validateCreateRequest(request);

        if ("USER".equalsIgnoreCase(request.getAuthorType())){
            userRepository.findById(request.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("User not Found !! "));
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
}
