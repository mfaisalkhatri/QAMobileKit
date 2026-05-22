package io.github.mfaisalkhatri.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.base.BaseTest;
import io.github.mfaisalkhatri.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin () {
        final LoginPage loginPage = new LoginPage ();
        loginPage.login ("admin@email.com", "Password@123");
        assertTrue (loginPage.isSuccessPopupDisplayed ());
        assertEquals (loginPage.getAlertTitle (), "Success");
        assertEquals (loginPage.getAlertMessage (), "You are logged in!");
    }
}