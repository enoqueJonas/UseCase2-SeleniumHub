package parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browserType")
    public void setup(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(browser.equalsIgnoreCase("firefox")){
            capabilities.setBrowserName("firefox");
        }
        if(browser.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName("chrome");
        }
        if(browser.equalsIgnoreCase("Edge")){
            capabilities.setBrowserName("MicrosoftEdge");
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    @Test
    void SeleniumTestDriverTest() throws InterruptedException {
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/SignIn.html");

        // Use WebDriverWait to wait for the element to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement menuToggleInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menuToggle']/input")));
        menuToggleInput.click();

        WebElement menuLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']/a[2]/li")));
        menuLink.click();

        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='usr']")));
        userField.sendKeys("sa");

        WebElement pwdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pwd']")));
        pwdField.sendKeys("sa");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='second_form']/input")));
        submitButton.click();

        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ShoeType']")));
        String expectedFirstProdCategory = "Formal Shoes";

        // Uncomment the following line to enable the assertion
        // Assert.assertEquals(expectedFirstProdCategory, webElement.getText());
    }
}
