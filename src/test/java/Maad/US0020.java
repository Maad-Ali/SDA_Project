package Maad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class US0020 {

    WebDriver driver;
    Wait<WebDriver> wait;

    @BeforeClass
    public void BeforeClass () {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

    }

    @Test
    public void US_20Test() throws InterruptedException {

        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        By LoginButton = By.className("login-button");
        driver.findElement(LoginButton).click();
        By Username = By.id("username");
        By Password = By.id("password");
        By SignIn = By.tagName("button");
        driver.findElement(Username).sendKeys("assurewise@assurewise.com");
        driver.findElement(Password).sendKeys("K_k-KaarTGk_48c");
        driver.findElement(SignIn).click();

        // you need to change id here
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By PermissionsModuleLink = By.id("link10");
        wait.until(f -> {
            driver.findElement(PermissionsModuleLink).getText();
            return true;
        });

        driver.findElement(PermissionsModuleLink).click();


        Thread.sleep(20000);

        wait.until(f -> {
            By PermissionsComponent = By.xpath("//div[contains(@class, 'col-lg-4') and contains(@class, 'col-md-6') and contains(@class, 'col-12') and contains(@class, 'd-grid') and contains(@class, 'mb-2')]");
            int actualNumberOfPermissions = driver.findElements(PermissionsComponent).size();
            Assert.assertEquals(actualNumberOfPermissions,94);
            return true;
        });
    }

    @AfterClass
    public void AfterClass() {
        //terminating session
        driver.quit();
    }
}
