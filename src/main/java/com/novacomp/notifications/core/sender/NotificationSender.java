package com.novacomp.notifications.core.sender;

import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;

public interface NotificationSender {
    NotificationResult send(Notification notification);
}
