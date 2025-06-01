package com.coursework.cs2coursework.service;

import com.coursework.cs2coursework.dto.ReviewDto;
import com.coursework.cs2coursework.entity.Review;
import com.coursework.cs2coursework.entity.User;
import com.coursework.cs2coursework.mapper.ReviewMapper;
import com.coursework.cs2coursework.repository.ReviewRepository;
import com.coursework.cs2coursework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;


    public ReviewDto createReview(ReviewDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Review review = ReviewMapper.toEntity(dto, user);
        reviewRepository.save(review);
        return ReviewMapper.toDto(review);
    }


    public ReviewDto getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        return ReviewMapper.toDto(review);
    }


    public List<ReviewDto> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(ReviewMapper::toDto)
                .collect(Collectors.toList());
    }
}