package com.coursework.cs2coursework.dto;


import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long userId;
    private Long skinId;
    private LocalDateTime orderDate;
    private String status;
}