package com.coursework.cs2coursework.service;

import com.coursework.cs2coursework.dto.ReviewDto;
import com.coursework.cs2coursework.entity.Review;
import com.coursework.cs2coursework.entity.User;
import com.coursework.cs2coursework.mapper.ReviewMapper;
import com.coursework.cs2coursework.repository.ReviewRepository;
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
class ReviewServiceTest {
    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    void testCreateReview() {
        User user = new User(1L, "Denis", "denis@example.com");
        ReviewDto reviewDto = new ReviewDto(null, 1L, "Great skin!", 5);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(reviewRepository.save(any(Review.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ReviewDto result = reviewService.createReview(reviewDto);

        assertNotNull(result);
        assertEquals("Great skin!", result.getReviewText());
        assertEquals(5, result.getRating());
        verify(reviewRepository, times(1)).save(any(Review.class));
    }
}