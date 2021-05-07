package com.eshoppingzone.service;

import com.eshoppingzone.pojo.EWallet;
import com.eshoppingzone.pojo.Statement;

import java.util.List;

public interface EWalletService {

    List<EWallet> getWallets();
    EWallet addWallet(EWallet eWallet);
    void addMoney(EWallet eWallet , double amount , String transactionType);
    void update(EWallet eWallet , double amount , String transactionType , int orderId);
    EWallet getById(int walletId);
    List<Statement> getStatementsById(int walletId);
    List<Statement> getAllStatements();
    void deleteById(int id);
}
