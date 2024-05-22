package Maad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class US0019 {
    WebDriver driver;
    Wait<WebDriver> wait;


    @BeforeClass
    public void BeforeClass () {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

    }

    @Test
    public void US_19Test() throws InterruptedException {

        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        By LoginButton=By.className("login-button");
        driver.findElement(LoginButton).click();
        By Username=By.id("username");
        By Password=By.id("password");
        By SignIn =By.tagName("button");
        driver.findElement(Username).sendKeys("assurewise@assurewise.com");
        driver.findElement(Password).sendKeys("EJWO_PWr17ePelV");
        driver.findElement(SignIn).click();


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By RolesModuleLink= By.id("link9");
        wait.until(f -> {
            driver.findElement(RolesModuleLink).getText();
            return true;
        });

        driver.findElement(RolesModuleLink).click();





        Thread.sleep(3000);
        By buttonLocator = By.xpath("//button[contains(@class,'btn btn-light border w-100 mw-100 text-start')]");
        List<WebElement> buttons = driver.findElements(buttonLocator);

        for (WebElement button : buttons) {
            // Wait for the button to be clickable
            WebElement clickableButton = wait.until(ExpectedConditions.elementToBeClickable(button));

            // Assert that the button is clickable
            Assert.assertNotNull(clickableButton, "Button is not clickable.");
        }

    }


    @AfterClass
    public void AfterClass() {
        //terminating session
        driver.quit();
    }


}
