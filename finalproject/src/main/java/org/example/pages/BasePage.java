package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver, String pageTitle) throws IllegalStateException {
        this.driver = driver;
        if(!pageTitle.equals(driver.getTitle())) {
            throw new IllegalStateException("Page title is incorrect." +
                    " Expected: " + pageTitle + ", Actual: " + driver.getTitle());
        }
    }

    public WebElement getWebElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void typeText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

}
