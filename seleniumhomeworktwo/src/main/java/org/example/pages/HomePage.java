package org.example.pages;

import org.example.components.Transaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage{
    private static final String PAGE_TITLE = "ACME demo app";

    private final By recentTransactionsBy = By.cssSelector("tbody tr");

    public HomePage(WebDriver driver) {
        super(driver, PAGE_TITLE);
    }

    public List<Transaction> getTransactions() {
        return driver.findElements(recentTransactionsBy)
                .stream()
                .map(Transaction::new)
                .collect(Collectors.toList());
    }

    public String getCreditAvailable() {
        By creditAvailableBy = RelativeLocator.with(By.cssSelector("div.balance-value"))
                .toRightOf(By.cssSelector("div.balance.hidden-mobile"));
        return driver.findElement(creditAvailableBy).findElement(creditAvailableBy).getText();
    }

}
