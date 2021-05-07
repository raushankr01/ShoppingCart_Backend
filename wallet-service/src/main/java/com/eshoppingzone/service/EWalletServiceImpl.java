package com.eshoppingzone.service;

import com.eshoppingzone.exception.ResourceNotFoundException;
import com.eshoppingzone.pojo.EWallet;
import com.eshoppingzone.pojo.Statement;
import com.eshoppingzone.repository.EWalletRepository;
import com.eshoppingzone.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class EWalletServiceImpl implements EWalletService {


    @Autowired
    private EWalletRepository eWalletRepository;

    @Autowired
    private StatementRepository statementRepository;

    @Override
    public List<EWallet> getWallets() {
        return eWalletRepository.findAll();
    }

    @Override
    public EWallet addWallet(EWallet eWallet) {
        return eWalletRepository.save(eWallet);
    }

    @Override
    public void addMoney(EWallet eWallet, double amount, String transactionType) {
        eWalletRepository.save(eWallet);
        Statement statement = new Statement();
        statement.setAmount(amount);
        statement.setDateTime(LocalDateTime.now());
        statement.setTransactionRemark("Success");
        statement.setTransactionType(transactionType);
        statement.setWallet(eWallet);
        statementRepository.save(statement);
    }

    @Override
    public void update(EWallet eWallet, double amount, String transactionType, int orderId) {
        eWalletRepository.save(eWallet);
        Statement statement = new Statement();
        statement.setAmount(amount);
        statement.setDateTime(LocalDateTime.now());
        statement.setOrderId(orderId);
        statement.setTransactionRemark("Success");
        statement.setTransactionType(transactionType);
        statement.setWallet(eWallet);
        statementRepository.save(statement);
    }

    @Override
    public EWallet getById(int walletId) {
        Optional<EWallet> found = Optional.ofNullable(eWalletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet Not Found With ID:- " + walletId)));
        return found.get();
    }

    @Override
    public List<Statement> getStatementsById(int walletId) {
        EWallet found = eWalletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("No Statements available for Wallet Id:- " + walletId));
        return found.getStatements();
    }

    @Override
    public List<Statement> getAllStatements() {
        return statementRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        EWallet wallet = eWalletRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not Found with ID:- " + id));
        eWalletRepository.delete(wallet);
    }
}
