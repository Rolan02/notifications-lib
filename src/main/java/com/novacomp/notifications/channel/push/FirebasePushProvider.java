package com.novacomp.notifications.channel.push;

import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class FirebasePushProvider implements PushProvider {

    private static final Logger log =
            LoggerFactory.getLogger(FirebasePushProvider.class);

    private final String serverKey;

    public FirebasePushProvider(String serverKey) {
        this.serverKey = serverKey;
    }

    @Override
    public NotificationResult send(Notification notification) {
        log.info(
                "Sending PUSH via Firebase to {} | title={} | body={}",
                notification.recipient().value(),
                notification.message().title(),
                notification.message().body()
        );

        return NotificationResult.success(
                "Firebase",
                UUID.randomUUID().toString()
        );
    }
}
