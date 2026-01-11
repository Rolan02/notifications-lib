package com.novacomp.test.notifications;

import com.novacomp.notifications.channel.email.EmailValidator;
import com.novacomp.notifications.core.exception.NotificationValidationException;
import com.novacomp.notifications.core.model.Message;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.Recipient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailValidatorTest {

    private final EmailValidator validator = new EmailValidator();

    @Test
    void shouldFailForInvalidEmail() {
        Notification notification = Notification.builder()
                .recipient(Recipient.of("invalid-email"))
                .message(Message.of("Hello"))
                .build();

        assertThrows(
                NotificationValidationException.class,
                () -> validator.validate(notification)
        );
    }
}
