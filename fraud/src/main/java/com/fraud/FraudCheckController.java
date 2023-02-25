package com.fraud;

import com.clients.fraud.CheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/fraud_check/")
public class FraudCheckController {
    private final FraudCheckService fraudCheckService;
    @GetMapping("{customerId}")
    public CheckResponse checkCustomer(@PathVariable("customerId") Integer customerId )
    {
       boolean isfraud= fraudCheckService.checkHistory(customerId);
       log.info("check custemer id = "+customerId+" isfraud ="+isfraud);

        return new CheckResponse(isfraud);
    }
}
