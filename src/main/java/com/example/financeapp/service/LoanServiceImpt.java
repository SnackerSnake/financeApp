package com.example.financeapp.service;

import com.example.financeapp.model.LoanApplication;
import com.example.financeapp.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpt implements LoanService{

    @Autowired
    LoanRepository loanRepository;
    @Override
    public List<LoanApplication> getAllLoan() {
        return loanRepository.findAll();
    }

    @Override
    public void saveLoan(LoanApplication loanApplication) {
        this.loanRepository.save(loanApplication);
    }

    @Override
    public LoanApplication getLoanById(long id) {
        Optional<LoanApplication> optional = loanRepository.findById(id);
        LoanApplication loanApplication = null;

        if(optional.isPresent()){
            loanApplication = optional.get();
        }else{
            throw new RuntimeException("loan Cannot be found");
        }
        return loanApplication;
    }

    @Override
    public void deleteLoanById(long id) {
        this.loanRepository.deleteById(id);
    }


    @Override
    public Page<LoanApplication> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
        return this.loanRepository.findAll(pageable);
    }
}
