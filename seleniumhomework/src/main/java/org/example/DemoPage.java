package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class DemoPage {
    private final String PAGE_URL = "https://demo.applitools.com/";
    private final WebDriver driver;
    private final Wait<WebDriver> wait;

    public DemoPage(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
        this.driver.get(PAGE_URL);
        logIn();
    }

    private void logIn() {
        String username = "user1";
        String password = "password";

        WebElement loginInputElement = wait.until(d -> d.findElement(By.id("username")));
        WebElement passwordInputElement = wait.until(d -> d.findElement(By.id("password")));
        WebElement loginButton = wait.until(d -> d.findElement(By.id("log-in")));

        loginInputElement.sendKeys(username);
        passwordInputElement.sendKeys(password);
        loginButton.click();
    }

    public void printFinancialOverview() {
        List<WebElement> balanceElements = wait.until(d ->
                d.findElements(By.cssSelector("div.balance-value:not(.danger)")));

        WebElement totalBalance = balanceElements.get(0);
        WebElement balanceText = totalBalance.findElement(By.cssSelector("span:not(.trending)"));
        System.out.println("Total Balance: " + balanceText.getText());

        WebElement creditAvailable = balanceElements.get(1);
        System.out.println("Credit Available: " + creditAvailable.getText());
        System.out.println();
    }

    public void printRecentTransactions() {
        System.out.println("Recent Transactions:");
        WebElement recentTransactionsTable = wait.until(d -> d.findElement(By.tagName("tbody")));
        List<WebElement> transactions = recentTransactionsTable.findElements(By.tagName("tr"));

        for (WebElement transaction : transactions) {
            WebElement statusCell = transaction.findElement(By.cssSelector("td.nowrap span:not(.status-pill)"));
            WebElement descriptionCell = transaction.findElement(By.cssSelector("td.cell-with-media span"));
            WebElement amountCell = transaction.findElement(By.cssSelector("td.text-right.bolder.nowrap span"));

            String statusText = statusCell.getText();
            String descriptionText = descriptionCell.getText();
            String amountText = amountCell.getText();

            String output = String.format("""
                    Status: %s
                    Description: %s
                    Amount: %s
                    """, statusText, descriptionText, amountText);

            System.out.println(output);
        }
    }
}
