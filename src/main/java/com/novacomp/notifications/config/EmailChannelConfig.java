package com.novacomp.notifications.config;

import com.novacomp.notifications.channel.email.EmailProvider;

import java.util.Objects;

public class EmailChannelConfig {

    private EmailProvider provider;

    public EmailChannelConfig provider(EmailProvider provider) {
        this.provider = provider;
        return this;
    }

    EmailProvider provider() {
        return Objects.requireNonNull(
                provider,
                "EmailProvider must be configured"
        );
    }
}
