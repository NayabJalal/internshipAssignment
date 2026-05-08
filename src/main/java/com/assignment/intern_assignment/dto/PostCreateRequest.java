package com.assignment.intern_assignment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostCreateRequest {
    @NotBlank
    private String content;

    @NotNull
    private Long authorId;

    @NotBlank
    private String authorType;
}
