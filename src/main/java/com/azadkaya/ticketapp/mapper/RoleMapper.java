package com.azadkaya.ticketapp.mapper;

import com.azadkaya.ticketapp.dto.request.RoleRequestDto;
import com.azadkaya.ticketapp.dto.response.RoleResponseDto;
import com.azadkaya.ticketapp.model.Role;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "users", ignore = true)
    Role toEntity(RoleRequestDto dto);

    RoleResponseDto toDto(Role role);

    List<RoleResponseDto> toDto(List<Role> roles);
}
