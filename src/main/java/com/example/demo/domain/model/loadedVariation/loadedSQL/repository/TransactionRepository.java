package com.example.demo.domain.model.loadedVariation.loadedSQL.repository;

import com.example.demo.domain.model.loadedVariation.loadedSQL.dto.TransactionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDTO,Long> {
    List<TransactionDTO> streamAllByIdBetween(long va1, long var2);
}
