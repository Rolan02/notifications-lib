package com.novacomp.notifications.channel.email;

import com.novacomp.notifications.core.channel.NotificationChannel;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;
import com.novacomp.notifications.validation.NotificationValidator;

import java.util.Objects;

public class EmailChannel implements NotificationChannel {

    private final EmailProvider provider;
    private final NotificationValidator validator;

    public EmailChannel(EmailProvider provider,
                        NotificationValidator validator) {
        this.provider = Objects.requireNonNull(provider);
        this.validator = Objects.requireNonNull(validator);
    }

    @Override
    public String name() {
        return "EMAIL";
    }

    public NotificationResult send(Notification notification) {
        validator.validate(notification);
        return provider.send(notification);
    }
}
