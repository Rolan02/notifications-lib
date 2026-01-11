package com.novacomp.test.notifications;

import com.novacomp.notifications.config.NotificationClient;
import com.novacomp.notifications.core.exception.NotificationException;
import com.novacomp.notifications.core.model.Notification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class NotificationClientTest {

    @Test
    void shouldFailWhenChannelNotConfigured() {
        NotificationClient client =
                new NotificationClient(Map.of());

        Notification notification = mock(Notification.class);
        when(notification.channel().name()).thenReturn("EMAIL");

        assertThrows(
                NotificationException.class,
                () -> client.send(notification)
        );
    }
}
