package com.coursework.cs2coursework.service;

import com.coursework.cs2coursework.dto.TransactionDto;
import com.coursework.cs2coursework.entity.Transaction;
import com.coursework.cs2coursework.entity.User;
import com.coursework.cs2coursework.repository.TransactionRepository;
import com.coursework.cs2coursework.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void testCreateTransaction() {
        User user = new User(1L, "Denis", "denis@example.com");
        TransactionDto transactionDto = new TransactionDto(null, 1L, new BigDecimal("100.00"), LocalDateTime.now());

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(transactionRepository.save(any(Transaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        TransactionDto result = transactionService.createTransaction(transactionDto);

        assertNotNull(result);
        assertEquals(new BigDecimal("100.00"), result.getAmount());
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }
}