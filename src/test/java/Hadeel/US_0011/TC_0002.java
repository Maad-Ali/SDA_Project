package Hadeel.US_0011;


import org.openqa.selenium.*;
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

import static org.testng.Assert.assertTrue;

public class TC_0002 {
    public static String email = "assurefour@four.com";
    public static String password = "h4VQAbAO8HNXSuE";
    public static String name = "Human Resource";
    public static String Shortname = "HR";
    public static String Describe = "The HR (Human Resources) department is responsible for managing the employee life cycle";
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void beforeMethod() {
        driver = new EdgeDriver();
        driver.get("https://qa-gm3.quaspareparts.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Initialize WebDriverWait with a timeout of 10 seconds
    }

    @Test
    public void TC0002() {
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
        //<add new unit>
        WebElement AddNewUnit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info float-end text-white']")));
        AddNewUnit.click();
        //<write short name>
        WebElement WriteAshortName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control fw-bold'])[2]")));
        WriteAshortName.sendKeys(Shortname);
        //<write a description>
        WebElement WriteAsescription = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control fw-bold'])[3]")));
        WriteAsescription.sendKeys(Describe);
        //<select dep type>
        WebElement selectDeptTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=' css-19bb58m'])[1]")));
        selectDeptTypeDropdown.click();
        WebElement optionTeam = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Remote Unit']")));
        optionTeam.click();
        //<save the values>
        WebElement saveTheValues = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info text-white px-3']")));
        saveTheValues.click();

        //<unsuccessful message appear >
        WebElement EmptyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-danger']")));
        assertTrue(EmptyName.isDisplayed(), "Unsuccessful message is not displayed");

    }

    @AfterMethod
    public void quitTabs() {
        driver.quit();

    }
}
