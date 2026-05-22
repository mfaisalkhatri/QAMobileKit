package io.github.mfaisalkhatri.pages;

import io.appium.java_client.AppiumBy;

public class HomePage extends BasePage {

    public void openMenu (final String menuName) {
        click (AppiumBy.accessibilityId (menuName));
    }
}
