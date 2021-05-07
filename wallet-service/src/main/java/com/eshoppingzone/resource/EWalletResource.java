package com.eshoppingzone.resource;

import com.eshoppingzone.pojo.EWallet;
import com.eshoppingzone.pojo.Statement;
import com.eshoppingzone.service.EWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/wallet")
public class EWalletResource {

    private final static String deposit = "Deposit";
    private final static String withdraw = "Withdraw";

    @Autowired
    private EWalletService eWalletService;

    @PostMapping("/addWallet/{walletId}")
    public ResponseEntity<EWallet> addWallet(@PathVariable("walletId") int walletId) {
        EWallet wallet = new EWallet();
        wallet.setWalletId(walletId);
        wallet.setCurrentBalance(50.0);
        return new ResponseEntity<EWallet>(eWalletService.addWallet(wallet) , HttpStatus.CREATED);
    }

    @GetMapping("/allWallets")
    public ResponseEntity<List<EWallet>> getAllWallets() {
        List<EWallet> found = eWalletService.getWallets();
        if(found.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<>(found , HttpStatus.OK);
        }
    }

    @GetMapping("/Id/{walletId}")
    public double getById(@PathVariable("walletId") int walletId) {
        EWallet found = eWalletService.getById(walletId);
        if(found.equals(null)) {
            return 0.0;
        }
        else {
            return found.getCurrentBalance();
        }
    }

    @PutMapping("/addMoney/{walletId}")
    public ResponseEntity<EWallet> addMoney(@PathVariable("walletId") int walletId , @RequestParam("currentBalance") double amount) {
        EWallet found = eWalletService.getById(walletId);
        if(amount > 0) {
            found.setCurrentBalance(found.getCurrentBalance() + amount);
            eWalletService.addMoney(found , amount , deposit);
            return new ResponseEntity<>(found , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(found , HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/payment/{walletId}")
    public ResponseEntity<EWallet> payMoney(@PathVariable("walletId") int walletId , @RequestParam("currentBalance")
            double amount , @RequestParam("orderId") int orderId) {
        EWallet found = eWalletService.getById(walletId);
        double availableBalance = found.getCurrentBalance();
        if(amount < availableBalance && amount > 0) {
            found.setCurrentBalance(found.getCurrentBalance() - amount);
            eWalletService.update(found , amount , withdraw , orderId);
            return new ResponseEntity<>(found , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/statement/{walletId}")
    public ResponseEntity<List<Statement>> getStatementsById(@PathVariable("walletId") int walletId) {
        List<Statement> statementList = eWalletService.getStatementsById(walletId);
        if(statementList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<>(statementList , HttpStatus.OK);
        }
    }

    @GetMapping("/statement/all")
    public List<Statement> getStatements() {
        return eWalletService.getAllStatements();
    }

    @DeleteMapping("/delete/{walletId}")
    public void deleteById(@PathVariable("walletId") int walletId) {
        eWalletService.deleteById(walletId);
    }
}
