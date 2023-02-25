package com.notification;

import com.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/notification")
public class NotificationController  {
    private final NotificationService notificationService;
    @PostMapping
    public void send_Notificaton(@RequestBody NotificationRequest notificationRequest){
        log.info(notificationRequest.getMessage());
        notificationService.send_Notification(notificationRequest);


    }
}
