package com.novacomp.notifications.config;

import com.novacomp.notifications.channel.sms.SmsProvider;

import java.util.Objects;

public class SmsChannelConfig {

    private SmsProvider provider;

    public SmsChannelConfig provider(SmsProvider provider) {
        this.provider = provider;
        return this;
    }

    SmsProvider provider() {
        return Objects.requireNonNull(
                provider,
                "SmsProvider must be configured"
        );
    }
}
