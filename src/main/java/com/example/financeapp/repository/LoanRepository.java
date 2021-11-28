package com.example.financeapp.repository;

import com.example.financeapp.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<LoanApplication, Long> {

    @Override
    Optional<LoanApplication> findById(Long id);

}
