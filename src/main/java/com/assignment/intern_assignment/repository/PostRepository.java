package com.assignment.intern_assignment.repository;

import com.assignment.intern_assignment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {

}
