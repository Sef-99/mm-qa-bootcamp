import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

abstract public class BaseTest {
    protected WebDriver driver;

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
