package com.coursework.cs2coursework.service;

import com.coursework.cs2coursework.dto.UserDto;
import com.coursework.cs2coursework.entity.User;
import com.coursework.cs2coursework.mapper.UserMapper;
import com.coursework.cs2coursework.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById() {
        User user = new User(1L, "Denis", "denis@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserDto result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Denis", result.getUsername());
        assertEquals("denis@example.com", result.getEmail());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateUser() {
        UserDto userDto = new UserDto(null, "Denis", "denis@example.com");
        User user = UserMapper.toEntity(userDto);
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDto result = userService.createUser(userDto);

        assertNotNull(result);
        assertEquals("Denis", result.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }
}