package org.gfg.WalletService.consumer;

import org.gfg.WalletService.service.WalletService;
import org.gfg.util.CommonConstants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    @Autowired
    WalletService walletService;


    @KafkaListener(topics = "TXN_INITIATE_QUEUE", groupId = "txn-initiate")
    public void listenNewTransactions(String data){
        System.out.println(data);

        JSONObject jsonObject = new JSONObject(data);

        String senderId = jsonObject.getString(CommonConstants.SENDER_ID);
        String receiverId = jsonObject.getString(CommonConstants.RECEIVER_ID);
        double amount = jsonObject.getDouble(CommonConstants.TXN_AMOUNT);
        String txnId = jsonObject.getString(CommonConstants.TXN_ID);

        walletService.processNewTransaction(senderId,receiverId,amount,txnId);

    }
}
