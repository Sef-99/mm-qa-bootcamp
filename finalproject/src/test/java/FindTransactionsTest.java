import org.example.components.Transaction;
import org.example.pages.CustomerCreatedPage;
import org.example.pages.FindTransactionsPage;
import org.example.pages.RegisterPage;
import org.example.pages.TransferFundsPage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindTransactionsTest extends BaseTest {
    private FindTransactionsPage findTransactionsPage;

    @BeforeMethod
    public void setUpBeforeMethods() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--auto-open-devtools-for-tabs");
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        RegisterPage registerPage = new RegisterPage(driver);
        CustomerCreatedPage customerCreatedPage = registerPage.createNewUserAndLogIn();
        TransferFundsPage transferFundsPage = customerCreatedPage.navigateToTransferFundsPage();
        transferFundsPage.transferFunds("100");
        transferFundsPage.transferFunds("150");
        findTransactionsPage = customerCreatedPage.navigateToFindTransactionsPage();
    }

    @Test
    public void givenFindTransactions_whenFindByAmount100_thenCorrectlyFindTransactions() {
        String searchAmount = "100";
        List<Transaction> transactionList = findTransactionsPage.findByAmount(searchAmount);

        String expectedFirstTransactionType = "Funds Transfer Sent";
        String expectedFirstTransactionDebit = "$100.00";

        String expectedSecondTransactionType = "Funds Transfer Received";
        String expectedSecondTransactionCredit = "$100.00";

        Assert.assertEquals(transactionList.size(), 2);

        Transaction firstTransaction = transactionList.get(0);
        Assert.assertEquals(firstTransaction.getTransactionType(), expectedFirstTransactionType);
        Assert.assertEquals(firstTransaction.getDebit(), expectedFirstTransactionDebit);
        Assert.assertEquals(firstTransaction.getCredit(), "");

        Transaction secondTransaction = transactionList.get(1);
        Assert.assertEquals(secondTransaction.getTransactionType(), expectedSecondTransactionType);
        Assert.assertEquals(secondTransaction.getCredit(), expectedSecondTransactionCredit);
        Assert.assertEquals(secondTransaction.getDebit(), "");
    }

    @Test
    public void givenFindTransactionsById_whenSearchingWithoutFilters_thenShowErrorMessage() {
        String actualErrorMessage = findTransactionsPage.searchWithEmptyFilters();

        String expectedErrorMessage = "Invalid transaction ID";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

}
