package com.example.demo.domain.model.loadedVariation.loadedSQL;

import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.model.loadedVariation.ILoadedVariation;
import com.example.demo.domain.model.loadedVariation.loadedSQL.dto.TransactionDTO;
import com.example.demo.domain.model.loadedVariation.loadedSQL.repository.TransactionRepository;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class LoadedDataBaseImpl implements ILoadedVariation {

    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> call() throws Exception {
        return transactionRepository.streamAllByIdBetween(0, 100)
                .stream()
                .map(TransactionDTO::toTransaction)
                .collect(Collectors.toList());
    }
}
