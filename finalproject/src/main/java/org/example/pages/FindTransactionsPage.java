package org.example.pages;

import org.example.components.Transaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class FindTransactionsPage extends BasePage {
    private final By transactionIdFieldBy = By.id("transactionId");
    private final By findByIdBy = By.id("findById");
    private final By amountFieldBy = By.id("amount");
    private final By findByAmount = By.id("findByAmount");
    private final By transactionTableBodyBy = By.id("transactionBody");
    private final By transactionIdErrorBy = By.id("transactionIdError");

    public FindTransactionsPage(WebDriver driver) throws IllegalStateException {
        super(driver, "ParaBank | Find Transactions");
    }

    public String searchWithEmptyFilters() {
        getWebElement(transactionIdFieldBy).clear();
        click(findByIdBy);
        return getWebElement(transactionIdErrorBy).getText();
    }

    public List<Transaction> findByAmount(String amount) {
        List<Transaction> transactions = new LinkedList<>();
        typeText(amountFieldBy, amount);
        click(findByAmount);
        List<WebElement> rows = getWebElement(transactionTableBodyBy).findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() == 4) {
                String date = columns.get(0).getText();
                String type = columns.get(1).getText();
                String debit = columns.get(2).getText();
                String credit = columns.get(3).getText();
                transactions.add(new Transaction(date, type, debit, credit));
            }
        }
        return transactions;
    }
}
