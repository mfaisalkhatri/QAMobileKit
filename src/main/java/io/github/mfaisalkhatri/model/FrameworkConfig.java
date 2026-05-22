package io.github.mfaisalkhatri.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrameworkConfig {
    private ExecutionConfig execution;
    private ServerConfig       server;
    private AppConfig          app;
    private List<DeviceConfig> devices;
}
