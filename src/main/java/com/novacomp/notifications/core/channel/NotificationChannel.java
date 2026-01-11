package com.novacomp.notifications.core.channel;

import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;

public interface NotificationChannel {

    String name();

    NotificationResult send(Notification notification);
}
