package com.coursework.cs2coursework.mapper;

import com.coursework.cs2coursework.dto.UserDto;
import com.coursework.cs2coursework.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getEmail());
    }

    public static User toEntity(UserDto dto) {
        return new User(dto.getId(), dto.getUsername(), dto.getEmail());
    }
}