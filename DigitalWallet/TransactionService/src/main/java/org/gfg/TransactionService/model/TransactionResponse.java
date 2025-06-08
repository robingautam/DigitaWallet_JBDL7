package org.gfg.TransactionService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionResponse {

    private double amount;
    private Date txnTime;
    private String sendTo;
    private String receiveFrom;
    private String txnId;
    private String txnType;
}
