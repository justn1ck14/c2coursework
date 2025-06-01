package com.coursework.cs2coursework.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}