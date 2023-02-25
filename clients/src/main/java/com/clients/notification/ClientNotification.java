package com.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        "notification"
)
public interface ClientNotification {
    @PostMapping("api/v1/notification")
    public void send_Notificaton(@RequestBody NotificationRequest notificationRequest);
}
