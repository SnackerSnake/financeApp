package com.example.financeapp.service;


import com.example.financeapp.model.LoanApplication;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoanService {

    List<LoanApplication> getAllLoan();
    void saveLoan(LoanApplication loanApplication);
    LoanApplication getLoanById(long id);
    void deleteLoanById(long id);
    Page<LoanApplication> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
