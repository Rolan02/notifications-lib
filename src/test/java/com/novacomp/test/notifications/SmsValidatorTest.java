package com.novacomp.test.notifications;

import com.novacomp.notifications.channel.sms.SmsValidator;
import com.novacomp.notifications.core.exception.NotificationValidationException;
import com.novacomp.notifications.core.model.Message;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.Recipient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SmsValidatorTest {

    private final SmsValidator validator = new SmsValidator();

    @Test
    void shouldFailForInvalidPhoneNumber() {
        Notification notification = Notification.builder()
                .recipient(Recipient.of("71234567"))
                .message(Message.of("OTP"))
                .build();

        assertThrows(
                NotificationValidationException.class,
                () -> validator.validate(notification)
        );
    }
}
