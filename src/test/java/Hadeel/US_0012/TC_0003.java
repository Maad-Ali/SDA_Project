package Hadeel.US_0012;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TC_0003 {
    public static String email = "assurewise@assurewise.com";
    public static String password = "EJWO_PWr17ePelV";
    public static String name = "Research and development";
    public static String EditThename = "Information Technology";
    public static String EditTheShortname = "IT";
    public static String EditDescribe = "Information technology is a set of related fields that encompass computer systems, software, programming languages and data and information processing and storage.";
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://qa-gm3.quaspareparts.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with a timeout of 10 seconds
    }

    @Test
    public void TC0003() {
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
        WebElement clickOnTheHR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#/department/1716291130693086/101']")));
        clickOnTheHR.click();
        //<click on Edit the Unit>
        WebElement clickOnEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info float-end text-white']")));
        clickOnEdit.click();
        driver.navigate().refresh();
        //<write a name>
        WebElement EditName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control fw-bold'])[1]")));
        EditName.clear();
        EditName.sendKeys(EditThename);
        //<write short name>
        WebElement EditShortName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control fw-bold'])[2]")));
        EditShortName.clear();
        EditShortName.sendKeys(EditTheShortname);
        //<write a description>
        WebElement EditDescription = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control fw-bold'])[3]")));
        EditDescription.clear();
        EditDescription.sendKeys(EditDescribe);
        //<select dep type>
        WebElement EditselectDeptTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=' css-1xc3v61-indicatorContainer'])[1]")));
        EditselectDeptTypeDropdown.click();
        //<save the values>
        WebElement saveTheEditValues = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info text-white px-3']")));
        saveTheEditValues.click();

        //<unsuccessful message appear >
        WebElement EmptyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-danger']")));
        assertTrue(EmptyName.isDisplayed(), "Unsuccessful message is not displayed");
    }
    @AfterMethod
    public void quitTabs() {
        driver.quit();
    }
}