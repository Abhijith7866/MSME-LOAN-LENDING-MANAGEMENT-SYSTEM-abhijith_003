package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Guarantor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guarantorId;
    private String name;
    private String relation;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    public Guarantor() {}


    public int getGuarantorId() { return guarantorId; }
    public void setGuarantorId(int guarantorId) { this.guarantorId = guarantorId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public Loan getLoan() { return loan; }
    public void setLoan(Loan loan) { this.loan = loan; }
}