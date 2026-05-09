package com.assignment.intern_assignment.service;

import com.assignment.intern_assignment.dto.CommentCreateRequest;
import com.assignment.intern_assignment.entity.Comment;

public interface ICommentService {
    Comment addComment(Long postId, CommentCreateRequest request);
}
