package io.github.mfaisalkhatri.config;

import io.github.mfaisalkhatri.model.FrameworkConfig;

public interface ConfigSource {

    FrameworkConfig loadConfig ();
}
