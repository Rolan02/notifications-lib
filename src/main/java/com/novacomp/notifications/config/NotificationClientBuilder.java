package com.novacomp.notifications.config;

import com.novacomp.notifications.channel.email.EmailChannel;
import com.novacomp.notifications.channel.email.EmailValidator;
import com.novacomp.notifications.channel.push.PushChannel;
import com.novacomp.notifications.channel.push.PushValidator;
import com.novacomp.notifications.channel.sms.SmsChannel;
import com.novacomp.notifications.channel.sms.SmsValidator;
import com.novacomp.notifications.core.channel.NotificationChannel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationClientBuilder {

    private final Map<String, NotificationChannel> channels = new HashMap<>();

    public NotificationClientBuilder email(
            Consumer<EmailChannelConfig> configurer) {

        EmailChannelConfig config = new EmailChannelConfig();
        configurer.accept(config);

        EmailChannel channel = new EmailChannel(
                config.provider(),
                new EmailValidator()
        );

        channels.put(channel.name(), channel);
        return this;
    }

    public NotificationClientBuilder sms(
            Consumer<SmsChannelConfig> configurer) {

        SmsChannelConfig config = new SmsChannelConfig();
        configurer.accept(config);

        SmsChannel channel = new SmsChannel(
                config.provider(),
                new SmsValidator()
        );

        channels.put(channel.name(), channel);
        return this;
    }

    public NotificationClientBuilder push(
            Consumer<PushChannelConfig> configurer) {

        PushChannelConfig config = new PushChannelConfig();
        configurer.accept(config);

        PushChannel channel = new PushChannel(
                config.provider(),
                new PushValidator()
        );

        channels.put(channel.name(), channel);
        return this;
    }

    public NotificationClient build() {
        return new NotificationClient(channels);
    }
}
