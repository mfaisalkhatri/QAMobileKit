package io.github.mfaisalkhatri.factory;

import java.net.URI;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.mfaisalkhatri.config.ConfigManager;
import io.github.mfaisalkhatri.model.AppConfig;
import io.github.mfaisalkhatri.model.DeviceConfig;
import io.github.mfaisalkhatri.model.ExecutionConfig;
import io.github.mfaisalkhatri.model.FrameworkConfig;
import io.github.mfaisalkhatri.model.ServerConfig;

public final class DriverFactory {
    public static AndroidDriver createDriver (final DeviceConfig device) {
        try {
            final FrameworkConfig config = ConfigManager.getFrameworkConfig ();
            final AppConfig appConfig = config.getAppConfig ();
            final ServerConfig serverConfig = config.getServerConfig ();
            final ExecutionConfig executionConfig = config.getExecutionConfig ();
            final UiAutomator2Options options = CapabilityFactory.getCapabilities (executionConfig, device, appConfig);
            return new AndroidDriver (URI.create (serverConfig.getUrl ())
                .toURL (), options);

        } catch (final IllegalStateException e) {
            throw new IllegalStateException ("Invalid Appium server URL configured for: " + device.getDeviceName ());
        } catch (final Exception e) {
            throw new IllegalStateException ("Failed to create AndroidDriver for device: " + device.getDeviceName (),
                e);
        }
    }
}
