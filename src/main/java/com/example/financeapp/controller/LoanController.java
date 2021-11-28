package com.example.financeapp.controller;


import com.example.financeapp.model.LoanApplication;
import com.example.financeapp.repository.LoanRepository;
import com.example.financeapp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LoanService loanService;

    @GetMapping("/loanList")
    public String viewLoanPage(Model model){
        model.addAttribute("listLoans", loanService.getAllLoan());
        return "LoanAppView";
    }

    @GetMapping("/ViewUploadApplication")
    public String viewUploadApplication(Model model){
        LoanApplication loanApplication = new LoanApplication();
        model.addAttribute("loan", loanApplication);
        return "new_Loan";
    }

    @PostMapping("/saveLoan")
    public String saveLoan(@ModelAttribute("loan") LoanApplication loanApplication){
        loanService.saveLoan(loanApplication);
        return"redirect:/loanList";
    }


    @GetMapping("/statusUpdateView/{id}")
    public String statusUpdateView(@PathVariable (value="id") long id, Model model){
        LoanApplication loanApplication = loanService.getLoanById(id);
        model.addAttribute("loan", loanApplication);
        return "update_loan";

    }
}
