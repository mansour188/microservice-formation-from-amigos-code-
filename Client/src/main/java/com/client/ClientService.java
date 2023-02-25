package com.client;


import com.clients.fraud.CheckResponse;
import com.clients.fraud.ClientFraud;
import com.clients.notification.ClientNotification;
import com.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Service
public class ClientService {
    private ClientRepo clientRepo;
     private  RestTemplate restTemplate;
     private ClientFraud clientFraud;
     private ClientNotification clientNotification;


    public void registerClient(ClientRequest clientRequest) {
        Client client = Client.builder()
                .firstName(clientRequest.firstname())
                .lastName(clientRequest.lastname())
                .email(clientRequest.email())
                .build();
        clientRepo.saveAndFlush(client);

        CheckResponse checkResponse=clientFraud.checkCustomer(client.getId());

        if (checkResponse.isFraudster()) {
            throw new IllegalArgumentException("Fraudest");

        }
        // send notification
        NotificationRequest notificationRequest=new NotificationRequest(
                client.getId(),
                client.getEmail(),
                String.format("hi %s  welcom to mansourApp ",client.getFirstName()),
                LocalDateTime.now()

                );

        clientNotification.send_Notificaton(notificationRequest);



    }
}
