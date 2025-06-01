package com.coursework.cs2coursework.service;

import com.coursework.cs2coursework.dto.OrderDto;
import com.coursework.cs2coursework.entity.Order;
import com.coursework.cs2coursework.entity.User;
import com.coursework.cs2coursework.entity.Skin;
import com.coursework.cs2coursework.mapper.OrderMapper;
import com.coursework.cs2coursework.repository.OrderRepository;
import com.coursework.cs2coursework.repository.UserRepository;
import com.coursework.cs2coursework.repository.SkinRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private SkinRepository skinRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testCreateOrder() {
        User user = new User(1L, "Denis", "denis@example.com");
        Skin skin = new Skin(1L, "Knife", "Rare", "image.png");
        OrderDto orderDto = new OrderDto(null, 1L, 1L, LocalDateTime.now(), "Pending");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(skinRepository.findById(1L)).thenReturn(Optional.of(skin));
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        OrderDto result = orderService.createOrder(orderDto);

        assertNotNull(result);
        assertEquals("Pending", result.getStatus());
        verify(orderRepository, times(1)).save(any(Order.class));
    }
}