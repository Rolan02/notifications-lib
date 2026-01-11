package com.novacomp.notifications.config;

import com.novacomp.notifications.channel.push.PushProvider;

import java.util.Objects;

public class PushChannelConfig {

    private PushProvider provider;

    public PushChannelConfig provider(PushProvider provider) {
        this.provider = provider;
        return this;
    }

    PushProvider provider() {
        return Objects.requireNonNull(
                provider,
                "PushProvider must be configured"
        );
    }
}
