package com.novacomp.notifications.channel.email;

import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;

public interface EmailProvider {
    NotificationResult send(Notification notification);
}
