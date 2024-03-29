package com.shoppingzone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDateTime;

public class Statement {

    private Integer statementId;
    @JsonBackReference
    private Ewallet ewallet;
    private String transactionType;
    private Double amount;
    private LocalDateTime dateTime;
    private Integer orderId;
    private String transactionRemarks;

    public Statement() {
    }

    public Statement(Integer statementId, String transactionType, Double amount, LocalDateTime dateTime,
                     Integer orderId, String transactionRemarks) {
        super();
        this.statementId = statementId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.orderId = orderId;
        this.transactionRemarks = transactionRemarks;
    }

    public Statement(Integer statementId, Ewallet ewallet, String transactionType, Double amount,
                     LocalDateTime dateTime, Integer orderId, String transactionRemarks) {
        super();
        this.statementId = statementId;
        this.ewallet = ewallet;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.orderId = orderId;
        this.transactionRemarks = transactionRemarks;
    }

    public Integer getStatementId() {
        return statementId;
    }

    public void setStatementId(Integer statementId) {
        this.statementId = statementId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public Ewallet getEwallet() {
        return ewallet;
    }

    public void setEwallet(Ewallet ewallet) {
        this.ewallet = ewallet;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getTransactionRemarks() {
        return transactionRemarks;
    }

    public void setTransactionRemarks(String transactionRemarks) {
        this.transactionRemarks = transactionRemarks;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "statementId=" + statementId +
                ", ewallet=" + ewallet +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", orderId=" + orderId +
                ", transactionRemarks='" + transactionRemarks + '\'' +
                '}';
    }
}
