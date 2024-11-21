package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterPage extends BasePage {

    private final By firstNameBy = By.id("customer.firstName");
    private final By lastNameBy = By.id("customer.lastName");
    private final By addressBy = By.id("customer.address.street");
    private final By cityBy = By.id("customer.address.city");
    private final By stateBy = By.id("customer.address.state");
    private final By zipBy = By.id("customer.address.zipCode");
    private final By ssnBy = By.id("customer.ssn");
    private final By usernameBy = By.id("customer.username");
    private final By passwordBy = By.id("customer.password");
    private final By confirmPasswordBy = By.id("repeatedPassword");
    private final By registerButton = By.cssSelector("td input.button");

    public RegisterPage(WebDriver driver) throws IllegalStateException {
        super(driver, "ParaBank | Register for Free Online Account Access");
    }

    public CustomerCreatedPage createNewUserAndLogIn() throws IllegalStateException{
        typeText(firstNameBy, "Enrique");
        typeText(lastNameBy, "Sanchez");
        typeText(addressBy, "Street");
        typeText(cityBy, "City");
        typeText(stateBy, "State");
        typeText(zipBy, "Zip");
        typeText(ssnBy, "SSN");
        String userName = "enrique";
        typeText(usernameBy, generateUsername(userName));
        typeText(passwordBy, "Password");
        typeText(confirmPasswordBy, "Password");
        click(registerButton);
        return new CustomerCreatedPage(driver);
    }

    private String generateUsername(String baseUsername) {
        String timestamp = new SimpleDateFormat("HHmmss").format(new Date());
        return baseUsername + timestamp;
    }

}
