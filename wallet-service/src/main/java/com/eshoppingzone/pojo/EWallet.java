package com.eshoppingzone.pojo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class EWallet {

    @Id
    private int walletId;
    private double currentBalance;

    @OneToMany(mappedBy = "wallet")
    @JsonManagedReference
    private List<Statement> statements;

    public EWallet() {

    }

    public EWallet(int walletId , double currentBalance) {
        super();
        this.walletId = walletId;
        this.currentBalance = currentBalance;
    }

    public EWallet(double currentBalance , List<Statement> statements) {
        super();
        this.currentBalance = currentBalance;
        this.statements = statements;
    }

    public EWallet(int walletId, double currentBalance, List<Statement> statements) {
        super();
        this.walletId = walletId;
        this.currentBalance = currentBalance;
        this.statements = statements;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "EWallet{" +
                "walletId=" + walletId +
                ", currentBalance=" + currentBalance +
                ", statements=" + statements +
                '}';
    }
}
