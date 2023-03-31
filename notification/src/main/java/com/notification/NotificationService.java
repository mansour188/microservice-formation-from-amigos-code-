package com.notification;

import com.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationReposotry notificationReposotry;
    public  void send_Notification(NotificationRequest notificationRequest){
        Notification notification= Notification
                .builder()

                .toCustomerId(notificationRequest.getToCustomerId())
                .toCustomerEmail(notificationRequest.getToCustomerEmail())
                .sender("mansour")
                .message(notificationRequest.getMessage())
                .sentAt(LocalDateTime.now())
                .build();
        notificationReposotry.save(notification);
    }


}
