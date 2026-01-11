package com.novacomp.notifications.channel.push;

import com.novacomp.notifications.core.exception.NotificationValidationException;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.validation.NotificationValidator;

public class PushValidator implements NotificationValidator {

    @Override
    public void validate(Notification notification) {
        String deviceToken = notification.recipient().value();

        if (deviceToken == null || deviceToken.isBlank()) {
            throw new NotificationValidationException(
                    "Device token must not be empty"
            );
        }

        if (notification.message().body() == null ||
                notification.message().body().isBlank()) {
            throw new NotificationValidationException(
                    "Push body must not be empty"
            );
        }
    }
}
