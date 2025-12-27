package com.examly.springapp.controller;

import com.examly.springapp.model.Loan;
import com.examly.springapp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
        return new ResponseEntity<>(loanService.addLoan(loan), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable int id) {
        return new ResponseEntity<>(loanService.getLoanById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable int id, @RequestBody Loan loan) {
        return new ResponseEntity<>(loanService.updateLoan(id, loan), HttpStatus.OK);
    }

    
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getLoansByStatus(@PathVariable String status) {
        List<Loan> loans = loanService.getLoansByStatus(status);
        if (loans.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No loans found with status: " + status);
        }
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
}