package com.novacomp.notifications.channel.push;

import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;

public interface PushProvider {
    NotificationResult send(Notification notification);
}
