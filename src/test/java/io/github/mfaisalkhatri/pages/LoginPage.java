package io.github.mfaisalkhatri.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By emailField    = AppiumBy.accessibilityId ("input-email");
    private final By passwordField = AppiumBy.accessibilityId ("input-password");
    private final By loginButton   = AppiumBy.accessibilityId ("button-LOGIN");
    private final By alertPopup    = AppiumBy.id ("android:id/content");
    private final By alertTitle    = AppiumBy.id ("android:id/alertTitle");
    private final By alertMessage  = AppiumBy.id ("android:id/message");
    private final By okButton      = AppiumBy.id ("android:id/button1");

    public void login (final String emailId, final String password) {
        type (this.emailField, emailId);
        type (this.passwordField, password);
        click (this.loginButton);
    }

    public boolean isSuccessPopupDisplayed () {
        return isDisplayed (this.alertPopup);
    }

    public String getAlertTitle () {
        return getText (this.alertTitle);
    }

    public String getAlertMessage () {
        return getText (this.alertMessage);
    }

    public void closeAlertPopup () {
        click (this.okButton);
    }
}
