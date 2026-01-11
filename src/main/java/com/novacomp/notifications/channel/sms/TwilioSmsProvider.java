package com.novacomp.notifications.channel.sms;

import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class TwilioSmsProvider implements SmsProvider {

    private static final Logger log =
            LoggerFactory.getLogger(TwilioSmsProvider.class);

    private final String accountSid;
    private final String authToken;

    public TwilioSmsProvider(String accountSid, String authToken) {
        this.accountSid = accountSid;
        this.authToken = authToken;
    }

    @Override
    public NotificationResult send(Notification notification) {
        log.info(
                "Sending SMS via Twilio to {} | body={}",
                notification.recipient().value(),
                notification.message().body()
        );
        return NotificationResult.success(
                "Twilio",
                UUID.randomUUID().toString()
        );
    }
}
