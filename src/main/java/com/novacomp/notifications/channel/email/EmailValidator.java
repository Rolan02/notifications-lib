package com.novacomp.notifications.channel.email;

import com.novacomp.notifications.core.exception.NotificationValidationException;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.validation.NotificationValidator;

import java.util.regex.Pattern;

public class EmailValidator implements NotificationValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    @Override
    public void validate(Notification notification) {
        String email = notification.recipient().value();

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new NotificationValidationException(
                    "Invalid email address: " + email
            );
        }

        if (notification.message().body() == null ||
                notification.message().body().isBlank()) {
            throw new NotificationValidationException(
                    "Email body must not be empty"
            );
        }
    }
}
