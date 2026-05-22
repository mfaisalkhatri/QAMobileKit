package io.github.mfaisalkhatri.pages;

import java.time.Duration;

import com.google.common.util.concurrent.ClosingFuture;
import io.appium.java_client.android.AndroidDriver;
import io.github.mfaisalkhatri.base.BaseTest;
import io.github.mfaisalkhatri.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage () {
        this.driver = DriverManager.getDriver ();
        this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (30));
    }

    protected WebElement find (final By locator) {
        return this.wait.until (ExpectedConditions.visibilityOfElementLocated (locator));
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