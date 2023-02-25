package com.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerEmail;

    private String message;
    private LocalDateTime sentAt;
}
