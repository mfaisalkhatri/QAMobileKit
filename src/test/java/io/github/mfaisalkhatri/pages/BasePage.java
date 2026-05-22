package io.github.mfaisalkhatri.pages;

import com.google.common.util.concurrent.ClosingFuture;
import io.appium.java_client.android.AndroidDriver;
import io.github.mfaisalkhatri.base.BaseTest;
import io.github.mfaisalkhatri.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected AndroidDriver driver;

    public BasePage () {
        this.driver = DriverManager.getDriver ();
    }

    protected WebElement find (final By locator) {
        return this.driver.findElement (locator);
    }

    protected void click (final By locator) {
        find (locator).click ();
    }

    protected void type (final By locator, final String text) {
        final WebElement element = find (locator);
        element.clear ();
        element.sendKeys (text);
    }

    protected String getText (final By locator) {
        return find (locator).getText ();
    }

    protected boolean isDisplayed (final By locator) {
        return find (locator).isDisplayed ();

    }
}