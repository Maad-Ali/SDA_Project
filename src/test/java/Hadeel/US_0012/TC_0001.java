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

import static org.testng.Assert.assertTrue;


public class TC_0001 {
    public static String email = "assurewise@assurewise.com";
    public static String password = "EJWO_PWr17ePelV";
    public static String name = "Research and development";
    public static String Editname = "Information Technology";
    public static String EditShortname = "IT";
    public static String EditDescribe = "Information technology is a set of related fields that encompass computer systems, software, programming languages and data and information processing and storage.";
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://qa-gm3.quaspareparts.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Initialize WebDriverWait with a timeout of 10 seconds
    }

    @Test
    public void TC0001() {
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
        WebElement clickOnTheHR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#/department/1716291130693086/76']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickOnTheHR);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickOnTheHR);
        //<click on Edit the Unit>
        WebElement clickOnEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info float-end text-white']")));
        clickOnEdit.click();
        //<write a name>
        WebElement EditName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control fw-bold'])[1]")));
        EditName.clear();
        EditName.sendKeys(Editname);
        //<write short name>
        WebElement EditShortName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control fw-bold'])[2]")));
        EditShortName.clear();
        EditShortName.sendKeys(EditShortname);
        //<write a description>
        WebElement EditDescription = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control fw-bold'])[3]")));
        EditDescription.clear();
        EditDescription.sendKeys(EditDescribe);
        //<select dep type>
        WebElement EditselectDeptTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=' css-19bb58m'])[1]")));
        EditselectDeptTypeDropdown.click();
        WebElement optionTeamEdited = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Team']")));
        optionTeamEdited.click();
        //<save the values>
        WebElement saveTheEditValues = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info text-white px-3']")));
        saveTheEditValues.click();

        //<successful message appear >
        WebElement successEditMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']")));
        assertTrue(successEditMessage.isDisplayed(), "Success message is not displayed after adding the unit.");
    }

    @AfterMethod
    public void quitTabs() {
        driver.quit();
    }
}
