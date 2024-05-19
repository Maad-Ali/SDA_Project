package Hadeel.US_0012;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class TC_0004 {
    public static String email = "pehicej808@bsomek.com";
    public static String password = "tAORf9zTeyKSP4R";
    public static String name = "Research and development";
    public static String Editname = "Information Technology";
    public static String EditShortname = "IT";
    public static String EditDescribe = "Information technology is a set of related fields that encompass computer systems, software, programming languages and data and information processing and storage.";
    public static String UnitPath = "//a[@href='#/department/1715254322840616/1669']";
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void beforeMethod() {
        driver = new EdgeDriver();
        driver.get("https://qa-gm3.quaspareparts.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with a timeout of 10 seconds
    }

    @Test
    public void TC0004() {
        By LoginPage = By.xpath("//a[@href='https://qa-gm3.quaspareparts.com/a3m/']");
        By usernameInput = By.xpath("//input[@id='username']");
        By passwordInput = By.xpath("//input[@id='password']");
        By submitButton = By.xpath("//button[@type='submit']");
        driver.findElement(LoginPage).click();
        driver.findElement(usernameInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();

        //<click on arrow icon>
        WebElement clickOnArrowElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='divCollapseUncollapse']")));
        clickOnArrowElement.click();
        //<click on remote unit>
        WebElement clickOnRemoteUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#/departments/remote']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickOnRemoteUnit);
        //<click on any Unit here : >
        WebElement clickOnTheHR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UnitPath)));
        clickOnTheHR.click();
        //<click on Edit the Unit>
        WebElement clickOnEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info float-end text-white']")));
        clickOnEdit.click();
        driver.navigate().refresh();
        //<click on delete>
        WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-light fw-bold float-end']")));
        delete.click();
        WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
        confirm.click();
        //make sure it gone
        WebElement clickOnArrowElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='divCollapseUncollapse']")));
        clickOnArrowElement1.click();
        //<click on remote unit>
        WebElement clickOnRemoteUnit1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#/departments/remote']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickOnRemoteUnit1);

        boolean unitDeleted = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(UnitPath)));

        // Log the status of the unit
        if (unitDeleted) {
            System.out.println("Unit is deleted as expected.");
        } else {
            System.out.println("Unit is still present in the DOM.");
        }

        // Assert that the unit is deleted
        assertTrue(unitDeleted, "The unit should be deleted.");

    }
    @AfterMethod
    public void quitTabs() {
        driver.quit();
    }
}