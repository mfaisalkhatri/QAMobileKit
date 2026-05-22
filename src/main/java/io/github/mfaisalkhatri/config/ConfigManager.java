package io.github.mfaisalkhatri.config;

import io.github.mfaisalkhatri.model.FrameworkConfig;
import lombok.Getter;

public final class ConfigManager {

    @Getter
    private static final FrameworkConfig config;

    static {
        final ConfigSource configSource = new YamlConfigSource ();
        config = configSource.loadConfig ();
    }

    private ConfigManager () {
    }
}