package com.novacomp.notifications.channel.sms;

import com.novacomp.notifications.core.exception.NotificationValidationException;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.validation.NotificationValidator;

import java.util.regex.Pattern;

public class SmsValidator implements NotificationValidator {

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\+[1-9]\\d{7,14}$");

    @Override
    public void validate(Notification notification) {
        String phone = notification.recipient().value();

        if (!PHONE_PATTERN.matcher(phone).matches()) {
            throw new NotificationValidationException(
                    "Invalid phone number: " + phone
            );
        }

        if (notification.message().body() == null ||
                notification.message().body().isBlank()) {
            throw new NotificationValidationException(
                    "SMS body must not be empty"
            );
        }

        if (notification.message().body().length() > 160) {
            throw new NotificationValidationException(
                    "SMS body exceeds 160 characters"
            );
        }
    }
}
