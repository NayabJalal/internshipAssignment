package com.assignment.intern_assignment.repository;

import com.assignment.intern_assignment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment , Long> {
}
