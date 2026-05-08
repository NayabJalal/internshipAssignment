package com.assignment.intern_assignment.service;

import com.assignment.intern_assignment.dto.UserCreateRequest;
import com.assignment.intern_assignment.entity.User;
import com.assignment.intern_assignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;

    @Override
    public User createUser(UserCreateRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .isPremium(request.getIsPremium())
                .build();
        return userRepository.save(user);
    }
}
