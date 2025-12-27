package com.examly.springapp.controller;

import com.examly.springapp.model.LoanType;
import com.examly.springapp.service.LoanTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loantypes")
public class LoanTypeController {

    @Autowired
    private LoanTypeService loanTypeService;

    @PostMapping
    public ResponseEntity<LoanType> addLoanType(@RequestBody LoanType loanType) {
        return new ResponseEntity<>(loanTypeService.addLoanType(loanType), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LoanType>> getAllLoanTypes() {
        return new ResponseEntity<>(loanTypeService.getAllLoanTypes(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanType> updateLoanType(@PathVariable int id, @RequestBody LoanType loanType) {
        return new ResponseEntity<>(loanTypeService.updateLoanType(id, loanType), HttpStatus.OK);
    }
}