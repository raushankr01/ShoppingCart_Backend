package com.eshoppingzone.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Statements")
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int statementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walletId")
    @JsonBackReference
    private EWallet wallet;
    private String transactionType;
    private double amount;
    private LocalDateTime dateTime;
    private int orderId;
    private String transactionRemark;

    public Statement() {

    }

    public Statement(int statementId, String transactionType, double amount, LocalDateTime dateTime, int orderId, String transactionRemark) {
        super();
        this.statementId = statementId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.orderId = orderId;
        this.transactionRemark = transactionRemark;
    }

    public Statement(int statementId, EWallet wallet, String transactionType, double amount, LocalDateTime dateTime, int orderId, String transactionRemark) {
        super();
        this.statementId = statementId;
        this.wallet = wallet;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.orderId = orderId;
        this.transactionRemark = transactionRemark;
    }

    public int getStatementId() {
        return statementId;
    }

    public void setStatementId(int statementId) {
        this.statementId = statementId;
    }

    public EWallet getWallet() {
        return wallet;
    }

    public void setWallet(EWallet wallet) {
        this.wallet = wallet;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTransactionRemark() {
        return transactionRemark;
    }

    public void setTransactionRemark(String transactionRemark) {
        this.transactionRemark = transactionRemark;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "statementId=" + statementId +
                ", wallet=" + wallet +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", orderId=" + orderId +
                ", transactionRemark='" + transactionRemark + '\'' +
                '}';
    }
}
