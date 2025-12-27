package com.examly.springapp.service;

import com.examly.springapp.model.Loan;
import com.examly.springapp.repository.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepo loanRepo;

    public Loan addLoan(Loan loan) {
        return loanRepo.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }

    public Loan getLoanById(int id) {
        return loanRepo.findById(id).orElse(null);
    }

    public Loan updateLoan(int id, Loan loan) {
        loan.setLoanId(id);
        return loanRepo.save(loan);
    }

    public List<Loan> getLoansByStatus(String status) {
        return loanRepo.findByStatus(status);
    }
}