package com.assignment.intern_assignment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LikeRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long postId;

}
