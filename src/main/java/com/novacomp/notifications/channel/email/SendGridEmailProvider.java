package com.novacomp.notifications.channel.email;


import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class SendGridEmailProvider implements EmailProvider {

    private static final Logger log =
            LoggerFactory.getLogger(SendGridEmailProvider.class);

    private final String apiKey;

    public SendGridEmailProvider(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public NotificationResult send(Notification notification) {
        log.info(
                "Sending EMAIL via SendGrid to {} | subject={} | body={}",
                notification.recipient().value(),
                notification.message().title(),
                notification.message().body()
        );

        return NotificationResult.success(
                "SendGrid",
                UUID.randomUUID().toString()
        );
    }
}
