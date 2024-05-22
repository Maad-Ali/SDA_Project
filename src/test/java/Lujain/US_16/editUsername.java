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

public class editUsername {
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

    }


    @Test
    public void editUsername() {
        By userLink = By.cssSelector("tbody tr:nth-child(1) td:nth-child(2) a:nth-child(1)");
        wait.until(ExpectedConditions.elementToBeClickable(userLink)).click();

        By editButton = By.xpath("//button[contains(@class , 'btn btn-ghost-dark rounded-circle')]");
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
        By usernameLabel = By.xpath("//input[@class='form-control fw-bold']");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLabel));
        usernameField.clear();
        usernameField.sendKeys("userfdd");
        By saveUpdate = By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']//*[name()='svg']");
        wait.until(ExpectedConditions.elementToBeClickable(saveUpdate)).click();

        By message = By.xpath("//div[@class='toast-body']");
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(messageElement.getText(), "User information updated successfully");
        softAssert.assertAll();
    }


}