package org.gfg.TransactionService.consumer;

import org.gfg.TransactionService.repository.TransactionRepository;
import org.gfg.enums.TxnStatus;
import org.gfg.util.CommonConstants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UpdatedTransactionConsumer {

    @Autowired
    TransactionRepository transactionRepository;

    @KafkaListener(topics = "TXN_UPDATE_QUEUE", groupId = "txn-update-group")
    public void listenUpdatedTransaction(String data){
        System.out.println(data);

        JSONObject jsonObject = new JSONObject(data);

        String txnId = jsonObject.getString(CommonConstants.TXN_ID);
        String txnMessage = jsonObject.getString(CommonConstants.TXN_MESSAGE);
        TxnStatus txnStatus = jsonObject.getEnum(TxnStatus.class,CommonConstants.TXN_STATUS);


        transactionRepository.updateTransactionDetails(txnId,txnStatus,txnMessage);

        System.out.println("Final Transaction Updated");
    }
}
