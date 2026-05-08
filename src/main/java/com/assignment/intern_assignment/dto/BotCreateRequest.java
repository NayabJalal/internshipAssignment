package com.assignment.intern_assignment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BotCreateRequest {
    @NotBlank
    private String name;

    private String personaDescription;

}
