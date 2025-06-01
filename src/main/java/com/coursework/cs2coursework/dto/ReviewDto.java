package com.coursework.cs2coursework.dto;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private Long userId;
    private String reviewText;
    private int rating;
}