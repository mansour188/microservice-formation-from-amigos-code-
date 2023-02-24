package com.fraud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service


public class FraudCheckService {
   final private FraudCheckRepo fraudCheckRepo;

@Autowired
    public FraudCheckService(FraudCheckRepo fraudCheckRepo) {
        this.fraudCheckRepo = fraudCheckRepo;
    }
public Boolean checkHistory(Integer  customerId){
     fraudCheckRepo.save(
             FraudCheckHistory.builder()
                     .customerId(customerId)
                     .createdAt(LocalDateTime.now())
                     .isFraudster(false).build()
     );
     return false;

}
}
