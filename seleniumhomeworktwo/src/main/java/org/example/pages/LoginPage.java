package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String PAGE_TITLE = "ACME Demo App by Applitools";

    private final By usernameBy = By.id("username");
    private final By passwordBy = By.id("password");
    private final By signInButtonBy = By.id("log-in");

    public LoginPage(WebDriver driver) {
        super(driver, PAGE_TITLE);

    }

    public HomePage logInValidUser(String username, String password) {
        typeText(usernameBy, username);
        typeText(passwordBy, password);
        click(signInButtonBy);
        return new HomePage(driver);
    }

    public LoginPage logInInvalidUser() {
        click(signInButtonBy);
        return new LoginPage(driver);
    }

}
