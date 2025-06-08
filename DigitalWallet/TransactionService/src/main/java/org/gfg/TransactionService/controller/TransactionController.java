package org.gfg.TransactionService.controller;

import org.gfg.TransactionService.model.Transaction;
import org.gfg.TransactionService.model.TransactionResponse;
import org.gfg.TransactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/initiate/transaction")
    public String initiateTransaction(@RequestParam("receiver") String receiver,
                                      @RequestParam("amount") String amount,
                                      @RequestParam("purpose") String purpose){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return  transactionService.initiateTransaction(userDetails.getUsername(),receiver,amount,purpose);


    }


    @GetMapping("/get/transaction/history")
    public List<TransactionResponse> getTransactionHistory(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return transactionService.getTransactionHistory(userDetails.getUsername());
    }



}
