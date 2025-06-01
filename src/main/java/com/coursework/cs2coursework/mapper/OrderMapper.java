package com.coursework.cs2coursework.mapper;

import com.coursework.cs2coursework.dto.OrderDto;
import com.coursework.cs2coursework.entity.Order;
import com.coursework.cs2coursework.entity.User;
import com.coursework.cs2coursework.entity.Skin;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderMapper {
    public static OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser().getId(),
                order.getSkin().getId(),
                order.getOrderDate(),
                order.getStatus()
        );
    }

    public static Order toEntity(OrderDto dto, User user, Skin skin) {
        return new Order(
                dto.getId(),
                user,
                skin,
                dto.getOrderDate(),
                dto.getStatus()
        );
    }
}