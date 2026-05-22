package io.github.mfaisalkhatri.factory;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.mfaisalkhatri.config.ConfigManager;
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
        options.setApp (getAppPath ());
        options.setAppPackage (appConfig.getAppPackage ());
        options.setAppActivity (appConfig.getAppActivity ());
        return options;
    }

    private static String getAppPath () {

        final URL appUrl = CapabilityFactory.class.getClassLoader ()
            .getResource (ConfigManager.getConfig ()
                .getApp ()
                .getAppPath ());

        if (appUrl == null) {
            throw new IllegalStateException ("APK file not found in resources folder");
        }

        try {

            return new File (appUrl.toURI ()).getAbsolutePath ();

        } catch (final URISyntaxException e) {

            throw new IllegalStateException ("Unable to resolve APK file path", e);
        }
    }
}