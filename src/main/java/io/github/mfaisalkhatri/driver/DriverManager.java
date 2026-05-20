package io.github.mfaisalkhatri.driver;

import io.appium.java_client.android.AndroidDriver;

public final class DriverManager {
    private static final ThreadLocal<AndroidDriver> DRIVER = new ThreadLocal<> ();

    public static void setDriver (final AndroidDriver driver) {
        DRIVER.set (driver);
    }

    public static AndroidDriver getDriver () {
        return DRIVER.get ();
    }

    public static void quitDriver () {
        final AndroidDriver driver = getDriver ();
        try {
            if (driver != null)
                driver.quit ();
        } finally {
            DRIVER.remove ();
        }
    }

    private DriverManager () {
    }
}