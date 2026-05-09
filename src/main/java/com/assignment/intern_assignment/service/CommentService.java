package com.assignment.intern_assignment.service;

import com.assignment.intern_assignment.dto.CommentCreateRequest;
import com.assignment.intern_assignment.entity.Comment;
import com.assignment.intern_assignment.entity.Post;
import com.assignment.intern_assignment.repository.CommentRepository;
import com.assignment.intern_assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService{

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public Comment addComment(Long postId, CommentCreateRequest request) {
        // Verify post exists
        postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = Comment.builder()
                .postId(postId)
                .authorId(request.getAuthorId())
                .authorType(Post.AuthorType.valueOf(request.getAuthorType().toUpperCase()))
                .content(request.getContent())
                .depthLevel(request.getDepthLevel() != null ? request.getDepthLevel() : 0)
                .parentCommentId(request.getParentCommentId())
                .build();
        return commentRepository.save(comment);
    }
}
