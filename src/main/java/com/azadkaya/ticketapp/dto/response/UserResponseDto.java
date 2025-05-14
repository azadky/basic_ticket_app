package com.azadkaya.ticketapp.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private List<String> roles;

}
