package com.assignment.intern_assignment.service;

import com.assignment.intern_assignment.dto.UserCreateRequest;
import com.assignment.intern_assignment.entity.User;

public interface IUserService {
    User createUser(UserCreateRequest request);
}
