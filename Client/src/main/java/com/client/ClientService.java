package com.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@AllArgsConstructor
@Service
public class ClientService {
    private ClientRepo clientRepo;
     private  RestTemplate restTemplate;

    public void registerClient(ClientRequest clientRequest) {
        Client client = Client.builder()
                .firstName(clientRequest.firstname())
                .lastName(clientRequest.lastname())
                .email(clientRequest.email())
                .build();
        clientRepo.saveAndFlush(client);
        CheckResponse checkResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud_check/{customerId}",
                CheckResponse.class, client.getId());
        if (checkResponse.isFraudster()) {
            throw new IllegalArgumentException("Fraudest");

        }




    }
}
