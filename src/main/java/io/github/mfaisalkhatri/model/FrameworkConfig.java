package io.github.mfaisalkhatri.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrameworkConfig {
    private ExecutionConfig    executionConfig;
    private ServerConfig       serverConfig;
    private AppConfig          appConfig;
    private List<DeviceConfig> deviceConfigList;
}
