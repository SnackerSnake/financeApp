package com.example.financeapp.model;
import javax.persistence.*;

@Entity
@Table(name="loanApplication")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="loanType")
    private String loanType;
    @Column(name="customerId")
    private String customerId;
    @Column(name="amount")
    private int loanAmount;
    @Column(name="status")
    private String status;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status;}
}
