package com.novacomp.notifications.channel.sms;

import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;

public interface SmsProvider {
    NotificationResult send(Notification notification);
}
