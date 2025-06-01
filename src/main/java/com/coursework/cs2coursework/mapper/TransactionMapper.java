package com.coursework.cs2coursework.mapper;

import com.coursework.cs2coursework.dto.TransactionDto;
import com.coursework.cs2coursework.entity.Transaction;
import com.coursework.cs2coursework.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransactionMapper {
    public static TransactionDto toDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getUser().getId(),
                transaction.getAmount(),
                transaction.getTimestamp()
        );
    }

    public static Transaction toEntity(TransactionDto dto, User user) {
        return new Transaction(
                dto.getId(),
                user,
                dto.getAmount(),
                dto.getTimestamp()
        );
    }
}