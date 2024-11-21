package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundsPage extends BasePage {
    private final By amountBy = By.id("amount");
    private final By transferButtonBy = By.cssSelector("div input.button");

    public TransferFundsPage(WebDriver driver) throws IllegalStateException{
        super(driver, "ParaBank | Transfer Funds");
    }

    public void transferFunds(String amount){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        typeText(amountBy, amount);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#fromAccountId option"), 0));
        click(transferButtonBy);
    }
}
