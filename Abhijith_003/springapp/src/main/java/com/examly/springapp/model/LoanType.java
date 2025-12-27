package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanTypeId;
    private String typeName;
    private String description;
    private Double interestRate;

    public LoanType() {}

    public LoanType(int loanTypeId, String typeName, String description, Double interestRate) {
        this.loanTypeId = loanTypeId;
        this.typeName = typeName;
        this.description = description;
        this.interestRate = interestRate;
    }

    public int getLoanTypeId() { return loanTypeId; }
    public void setLoanTypeId(int loanTypeId) { this.loanTypeId = loanTypeId; }
    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getInterestRate() { return interestRate; }
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }
}