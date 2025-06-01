package com.coursework.cs2coursework.service;

import com.coursework.cs2coursework.dto.OrderDto;
import com.coursework.cs2coursework.entity.Order;
import com.coursework.cs2coursework.entity.User;
import com.coursework.cs2coursework.entity.Skin;
import com.coursework.cs2coursework.mapper.OrderMapper;
import com.coursework.cs2coursework.repository.OrderRepository;
import com.coursework.cs2coursework.repository.UserRepository;
import com.coursework.cs2coursework.repository.SkinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final SkinRepository skinRepository;

    public OrderDto createOrder(OrderDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Skin skin = skinRepository.findById(dto.getSkinId())
                .orElseThrow(() -> new RuntimeException("Skin not found"));

        Order order = OrderMapper.toEntity(dto, user, skin);
        orderRepository.save(order);
        return OrderMapper.toDto(order);
    }


    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderMapper.toDto(order);
    }


    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }
}