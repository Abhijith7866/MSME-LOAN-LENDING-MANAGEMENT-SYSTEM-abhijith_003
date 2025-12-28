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
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
        return new ResponseEntity<>(loanService.addLoan(loan), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Loan> getAllLoans() { return loanService.getAllLoans(); }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable int id) {
        Loan loan = loanService.getLoanById(id);
        return loan != null ? ResponseEntity.ok(loan) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable int id, @RequestBody Loan loan) {
        Loan updated = loanService.updateLoan(id, loan);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<?> getLoansByStatus(@PathVariable String status) {
        List<Loan> loans = loanService.getLoansByStatus(status);
        return loans.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).body("No loans found") : ResponseEntity.ok(loans);
    }
}