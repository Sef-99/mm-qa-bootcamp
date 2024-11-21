package org.example;

import org.example.components.Transaction;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demo.applitools.com/");
        LoginPage loginPage = new LoginPage(this.driver);
        homePage = loginPage.logInValidUser("validUser", "validPass");
    }

    @Test
    public void testAmountOfRecentTransactions() {
        List<Transaction> transactionList = homePage.getTransactions();
        System.out.println(homePage.getCreditAvailable());

        System.out.println(transactionList);

        int expectedSize = 6;
        Assert.assertEquals(transactionList.size(), expectedSize);
    }

    @Test
    public void testCreditAvailable() {
        String creditAvailable = homePage.getCreditAvailable();

        String expectedCreditAvailable = "$17,800";

        Assert.assertEquals(creditAvailable, expectedCreditAvailable);
    }
}
