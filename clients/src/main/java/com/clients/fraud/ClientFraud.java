package com.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        "fraud"
)
public interface ClientFraud {
    @GetMapping("api/v1/fraud_check/{customerId}")
    CheckResponse checkCustomer(@PathVariable("customerId") Integer customerId );
}
