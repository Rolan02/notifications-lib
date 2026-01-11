package com.novacomp.test.notifications;

import com.novacomp.notifications.channel.email.EmailChannel;
import com.novacomp.notifications.channel.email.EmailProvider;
import com.novacomp.notifications.core.model.Message;
import com.novacomp.notifications.core.model.Notification;
import com.novacomp.notifications.core.model.NotificationResult;
import com.novacomp.notifications.core.model.Recipient;
import com.novacomp.notifications.validation.NotificationValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmailChannelTest {

    @Test
    void shouldDelegateToProviderAfterValidation() {
        EmailProvider provider = mock(EmailProvider.class);
        NotificationValidator validator = mock(NotificationValidator.class);

        Notification notification = Notification.builder()
                .recipient(Recipient.of("user@bank.com"))
                .message(Message.of("Hello"))
                .build();

        when(provider.send(notification))
                .thenReturn(NotificationResult.success("SendGrid", "123"));

        EmailChannel channel = new EmailChannel(provider, validator);

        NotificationResult result = channel.send(notification);

        verify(validator).validate(notification);
        verify(provider).send(notification);
        assertEquals(NotificationResult.Status.SUCCESS, result.status());
    }
}
