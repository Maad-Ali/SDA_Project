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

public class addNewRole {
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

    public void addNewRole() {
        // ADD NEW ROLES.
        By newRole = By.xpath("//img[contains(@class , 'ms-2 cursor-pointer')]");
        By accountantOption = By.xpath("//div[contains(@class,'css-1n7v3ny-option')][contains(text(),'Accountant')]");

        // Click on the new role button
        wait.until(ExpectedConditions.elementToBeClickable(newRole)).click();

        // Click on the Accountant option in the dropdown
        wait.until(ExpectedConditions.elementToBeClickable(accountantOption)).click();

        // Click on the save button
        By saveButton = By.xpath("//button[@class='btn btn-info float-end text-white']");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }



}

