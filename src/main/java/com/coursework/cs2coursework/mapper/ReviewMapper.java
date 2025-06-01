package com.coursework.cs2coursework.mapper;

import com.coursework.cs2coursework.dto.ReviewDto;
import com.coursework.cs2coursework.entity.Review;
import com.coursework.cs2coursework.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReviewMapper {
    public static ReviewDto toDto(Review review) {
        return new ReviewDto(
                review.getId(),
                review.getUser().getId(),
                review.getReviewText(),
                review.getRating()
        );
    }

    public static Review toEntity(ReviewDto dto, User user) {
        return new Review(
                dto.getId(),
                user,
                dto.getReviewText(),
                dto.getRating()
        );
    }
}