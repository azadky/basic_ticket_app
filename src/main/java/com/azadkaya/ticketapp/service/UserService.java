package com.azadkaya.ticketapp.service;

import com.azadkaya.ticketapp.dto.request.UserRequestDto;
import com.azadkaya.ticketapp.dto.response.UserResponseDto;
import com.azadkaya.ticketapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDto> findAll();

    UserResponseDto finByUserId(Long userId);

    UserResponseDto createRegister(UserRequestDto dto);

    Optional<User> getUserWithAuthorities();
}
