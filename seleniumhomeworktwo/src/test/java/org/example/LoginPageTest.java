package org.example;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demo.applitools.com/");
        loginPage = new LoginPage(this.driver);
    }

    @Test
    public void testLogInValidUser() {
        HomePage homePage = loginPage.logInValidUser("validUsername", "validPassword");
        Assert.assertNotNull(homePage, "Login failed, HomePage is null.");
    }

    @Test
    public void testLogInInvalidUser() {
        LoginPage invalidLoginPage = loginPage.logInInvalidUser();
        Assert.assertNotNull(invalidLoginPage, "Login should fail, but returned a valid page.");
    }
}