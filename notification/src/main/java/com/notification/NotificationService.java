package com.notification;

import com.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationReposotry notificationReposotry;
    public  void send_Notification(NotificationRequest notificationRequest){
        Notification notification= Notification
                .builder()
                .sentAt(notificationRequest.getSentAt())
                .toCustomerId(notificationRequest.getToCustomerId())
                .toCustomerEmail(notificationRequest.getToCustomerEmail())
                .sender("mansour")
                .message(notificationRequest.getMessage())
                .build();
        notificationReposotry.save(notification);
    }


}
