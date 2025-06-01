package com.coursework.cs2coursework.service;

import com.coursework.cs2coursework.dto.TransactionDto;
import com.coursework.cs2coursework.entity.Transaction;
import com.coursework.cs2coursework.entity.User;
import com.coursework.cs2coursework.mapper.TransactionMapper;
import com.coursework.cs2coursework.repository.TransactionRepository;
import com.coursework.cs2coursework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;


    public TransactionDto createTransaction(TransactionDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Transaction transaction = TransactionMapper.toEntity(dto, user);
        transactionRepository.save(transaction);
        return TransactionMapper.toDto(transaction);
    }


    public TransactionDto getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return TransactionMapper.toDto(transaction);
    }


    public List<TransactionDto> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(TransactionMapper::toDto)
                .collect(Collectors.toList());
    }
}