package Lujain.US_16;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class resetPassword{
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        login();
    }

    public void login() {
        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        By loginButton = By.className("login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        By username = By.id("username");
        By password = By.id("password");
        By signIn = By.tagName("button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("assurewise@assurewise.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("EJWO_PWr17ePelV");
        wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();

        By usersModuleLink = By.id("link8");
        wait.until(ExpectedConditions.elementToBeClickable(usersModuleLink)).click();
    }

    @Test
    public void resetPassword() {
        By userLink = By.cssSelector("tbody tr:nth-child(1) td:nth-child(2) a:nth-child(1)");
        wait.until(ExpectedConditions.elementToBeClickable(userLink)).click();

        By changePass = By.xpath("//button[contains(@class ,'btn btn-ghost-info float-end')]");
        By confirmButton = By.xpath("//button[contains(@class ,'btn btn-dark text-white me-2')]");
        By resetPassMessage = By.xpath("//h5[contains(@class ,'text-center bg-success text-white rounded p-2')]");
        By closeButton = By.xpath("//button[contains(@class ,'btn btn-dark text-white me-2')]");
        wait.until(ExpectedConditions.elementToBeClickable(changePass)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();

        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(resetPassMessage));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(messageElement.getText(), "Reset password successfully");
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
        softAssert.assertAll();
    }

}

