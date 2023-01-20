package com.example.userservice.service;

import com.example.userservice.dto.ResponseDto;
import com.example.userservice.model.User;

public interface UserService {
    User createUser(User user);
    ResponseDto getUser(Long id);
}
