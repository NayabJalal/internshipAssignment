package com.assignment.intern_assignment.service;

import com.assignment.intern_assignment.dto.LikeRequest;
import com.assignment.intern_assignment.dto.PostCreateRequest;
import com.assignment.intern_assignment.entity.Post;

public interface IPostService {
    Post createPost(PostCreateRequest request);
    void likePost(Long postId , LikeRequest request);
}
