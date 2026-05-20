package io.github.mfaisalkhatri.factory;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.mfaisalkhatri.model.AppConfig;
import io.github.mfaisalkhatri.model.DeviceConfig;
import io.github.mfaisalkhatri.model.ExecutionConfig;

public final class CapabilityFactory {

    public static UiAutomator2Options getCapabilities (final ExecutionConfig executionConfig, final DeviceConfig device,
        final AppConfig appConfig) {
        final UiAutomator2Options options = new UiAutomator2Options ();
        options.setPlatformName (executionConfig.getPlatform ());
        options.setPlatformVersion (device.getPlatformVersion ());
        options.setDeviceName (device.getDeviceName ());
        options.setAutomationName (device.getAutomationName ());
        options.setApp (appConfig.getAppPath ());
        options.setAppPackage (appConfig.getAppPackage ());
        options.setAppActivity (appConfig.getAppActivity ());
        return options;
    }
}