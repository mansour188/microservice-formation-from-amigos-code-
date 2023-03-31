package com.client;


import com.amqp.RabbitMQMessageProducer;
import com.clients.fraud.CheckResponse;
import com.clients.fraud.ClientFraud;
import com.clients.notification.ClientNotification;

import com.clients.notification.NotificationRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
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
     final private RabbitMQMessageProducer rabbitMQMessageProducer;


    public void registerClient(ClientRequest clientRequest)  {
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
        NotificationRequest notificationRequest=new NotificationRequest(
                client.getId(),
                client.getEmail(),
                String.format("hi %s  welcom to mansourApp ",client.getFirstName())

        );



        // clientNotification.send_Notificaton(notificationRequest);  //using feign and http is sync

        //async use rabbit Q

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
        // send notification




    }
}
