package com.assignment.intern_assignment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    private Long authorId;

    private LocalDateTime createdAt;

    @Enumerated
    private AuthorType authorType;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
    }
    public enum AuthorType{
        USER,
        BOT
    }
}
