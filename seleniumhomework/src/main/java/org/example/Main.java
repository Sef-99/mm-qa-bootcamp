package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(300));

        try {
            DemoPage demoPage = new DemoPage(driver, wait);
            demoPage.printFinancialOverview();
            demoPage.printRecentTransactions();
        } catch (Exception e) {
            System.err.println("An error occurred while processing the demo page transactions: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }


    }
}