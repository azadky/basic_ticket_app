package com.azadkaya.ticketapp.mapper;

import com.azadkaya.ticketapp.dto.request.UserRequestDto;
import com.azadkaya.ticketapp.model.User;
import org.mapstruct.Mapper;

import com.azadkaya.ticketapp.dto.response.UserResponseDto;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    User toEntity(UserRequestDto dto);

    @Mapping(target = "roles", source = "user", qualifiedByName = "extractRoleNames")
    UserResponseDto toDto(User user);

    List<UserResponseDto> toDto(List<User> userList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles", ignore = true)
    void partialUpdate(@MappingTarget User user, UserRequestDto dto);

    @Named("extractRoleNames")
    default List<String> extractRoleNames(User user) {
        return user.getRoles().stream()
                .map(role -> role.getName())
                .collect(Collectors.toList());
    }
}

