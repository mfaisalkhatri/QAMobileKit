package io.github.mfaisalkhatri.config;

import io.github.mfaisalkhatri.model.FrameworkConfig;
import lombok.Getter;

public final class ConfigManager {

    @Getter
    private static final FrameworkConfig frameworkConfig;

    static {
        final ConfigSource configSource = new YamlConfigSource ();
        frameworkConfig = configSource.loadConfig ();
    }
}