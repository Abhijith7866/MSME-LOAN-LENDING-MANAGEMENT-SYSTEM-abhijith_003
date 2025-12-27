package com.examly.springapp.service;

import com.examly.springapp.model.LoanType;
import com.examly.springapp.repository.LoanTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanTypeService {
    @Autowired
    private LoanTypeRepo loanTypeRepo;

    public LoanType addLoanType(LoanType loanType) {
        return loanTypeRepo.save(loanType);
    }

    public List<LoanType> getAllLoanTypes() {
        return loanTypeRepo.findAll();
    }

    public LoanType updateLoanType(int id, LoanType loanType) {
        loanType.setLoanTypeId(id);
        return loanTypeRepo.save(loanType);
    }
}