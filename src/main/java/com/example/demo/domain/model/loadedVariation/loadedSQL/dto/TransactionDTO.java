package com.example.demo.domain.model.loadedVariation.loadedSQL.dto;

import com.example.demo.domain.model.Transaction;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
public class TransactionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    long number;
    LocalDate localDate;
    BigInteger sum;

    public TransactionDTO() {
    }

    private TransactionDTO(long number, LocalDate localDate, BigInteger sum) {
        this.number = number;
        this.localDate = localDate;
        this.sum = sum;
    }

    public static TransactionDTO fromTransaction(Transaction transaction){
        return new TransactionDTO(
                transaction.getNumber(),
                transaction.getLocalDate(),
                transaction.getSum());
    }

    public static Transaction toTransaction(TransactionDTO transactionDTO){
        return new Transaction(
                transactionDTO.getNumber(),
                transactionDTO.getLocalDate(),
                transactionDTO.getSum()
        );
    }
}
