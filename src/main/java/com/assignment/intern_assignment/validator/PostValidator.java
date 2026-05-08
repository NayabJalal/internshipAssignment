package com.assignment.intern_assignment.validator;

import com.assignment.intern_assignment.dto.PostCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class PostValidator {
    public void validateCreateRequest(PostCreateRequest request){
        if (request.getContent() == null || request.getContent().trim().isEmpty()){
            throw new RuntimeException("Post Content cannot be empty !! ");
        }
        if (request.getContent().length() > 1000){
            throw new RuntimeException("Post Content cannot exceed 1000 characters !! ");
        }
        if (request.getAuthorId() == null){
            throw new RuntimeException("Author ID is required !! ");
        }
        if (request.getAuthorType() == null ||
                (!request.getAuthorType().equalsIgnoreCase("USER"))
                && (!request.getAuthorType().equalsIgnoreCase("BOT"))
        ){
            throw new RuntimeException("Author Type must be a 'USER' or 'BOT' ");
        }
    }
}
