package org.example.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Transaction extends BaseComponent {
    private final String statusText;
    private final String descriptionText;
    private final String amountText;

    public Transaction(WebElement root) {
        super(root);
        statusText = root.findElement(By.cssSelector("td.nowrap span:not(.status-pill)")).getText();
        descriptionText = root.findElement(By.cssSelector("td.nowrap span:not(.status-pill)")).getText();
        amountText = root.findElement(By.cssSelector("td.text-right.bolder.nowrap span")).getText();
    }

    private String getStatusText() {
        return statusText;
    }

    private String getDescriptionText() {
        return descriptionText;
    }

    private String getAmountText() {
        return amountText;
    }

    @Override
    public String toString() {
        return """
            Transaction:
                statusText='%s',
                descriptionText='%s',
                amountText='%s'
   
            """.formatted(getStatusText(), getDescriptionText(), getAmountText());
    }

}
