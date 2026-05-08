package com.assignment.intern_assignment.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserCreateRequest {
    @NotBlank
    private String username;

    @NotNull
    private Boolean isPremium;
}
