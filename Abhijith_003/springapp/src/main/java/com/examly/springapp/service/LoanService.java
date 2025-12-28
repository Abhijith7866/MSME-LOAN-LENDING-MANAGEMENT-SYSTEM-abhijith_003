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
        if (loan.getStatus() == null || loan.getStatus().isEmpty()) {
            loan.setStatus("PENDING");
        }
        return loanRepo.save(loan);
    }

    public List<Loan> getAllLoans() { return loanRepo.findAll(); }
    public Loan getLoanById(int id) { return loanRepo.findById(id).orElse(null); }
    public List<Loan> getLoansByStatus(String status) { return loanRepo.findByStatus(status); }

    public Loan updateLoan(int id, Loan details) {
        return loanRepo.findById(id).map(loan -> {
            if(details.getLoanAmount() != null) loan.setLoanAmount(details.getLoanAmount());
            if(details.getStatus() != null) loan.setStatus(details.getStatus());
            if(details.getTenureMonths() > 0) loan.setTenureMonths(details.getTenureMonths());
            return loanRepo.save(loan);
        }).orElse(null);
    }
}