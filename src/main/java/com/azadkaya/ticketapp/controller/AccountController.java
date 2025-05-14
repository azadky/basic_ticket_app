package com.azadkaya.ticketapp.controller;

import com.azadkaya.ticketapp.dto.request.UserRequestDto;
import com.azadkaya.ticketapp.dto.response.UserResponseDto;
import com.azadkaya.ticketapp.mapper.UserMapper;
import com.azadkaya.ticketapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping(value = "createRegister")
    public UserResponseDto createRegister(@RequestBody UserRequestDto dto) {
        return userService.createRegister(dto);
    }

    @GetMapping
    public UserResponseDto getAccount(){
        return userService
                .getUserWithAuthorities()
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User could not be found"));
    }

    @GetMapping("/{id}")
    public UserResponseDto findByUserId(@PathVariable Long userId) {
        return userService.finByUserId(userId);
    }
}
