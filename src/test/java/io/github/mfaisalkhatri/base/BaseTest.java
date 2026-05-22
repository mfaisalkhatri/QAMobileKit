package io.github.mfaisalkhatri.base;

import java.sql.Driver;

import io.appium.java_client.android.AndroidDriver;
import io.github.mfaisalkhatri.config.ConfigManager;
import io.github.mfaisalkhatri.driver.DriverManager;
import io.github.mfaisalkhatri.factory.DriverFactory;
import io.github.mfaisalkhatri.model.DeviceConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeClass (alwaysRun = true)
    @Parameters ("device")
    public void setup (final String deviceName) {
        final DeviceConfig deviceConfig = ConfigManager.getFrameworkConfig ()
            .getDeviceConfigList ()
            .stream ()
            .filter (d -> d.getDeviceName ()
                .equalsIgnoreCase (deviceName))
            .findFirst ()
            .orElseThrow (() -> new IllegalArgumentException ("Device Not Found" + deviceName));

        final AndroidDriver driver = DriverFactory.createDriver (deviceConfig);
        DriverManager.setDriver (driver);
        System.out.println ("Driver started for: " + deviceName);
    }

    @AfterClass (alwaysRun = true)
    public void tearDown () {
        DriverManager.quitDriver ();
    }
}