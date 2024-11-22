package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerCreatedPage extends BasePage {
    private final By transferFundsBy = By.cssSelector("a[href='transfer.htm']");
    private final By findTransactionsBy = By.cssSelector("a[href='findtrans.htm']");

    public CustomerCreatedPage(WebDriver driver) throws IllegalStateException {
        super(driver, "ParaBank | Customer Created");
    }

    public TransferFundsPage navigateToTransferFundsPage() {
        click(transferFundsBy);
        return new TransferFundsPage(driver);
    }

    public FindTransactionsPage navigateToFindTransactionsPage() {
        click(findTransactionsBy);
        return new FindTransactionsPage(driver);
    }

}
