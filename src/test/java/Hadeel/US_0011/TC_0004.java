package Hadeel.US_0011;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TC_0004 {
    WebDriver driver;
    WebDriverWait wait;

    public static String email = "pehicej808@bsomek.com";
    public static String password = "tAORf9zTeyKSP4R";

    public static String name = "Human Resource";
    public static String Shortname = "HR";
    public static String Describe = "The HR (Human Resources) department is responsible for managing the employee life cycle";
    public static String Editname = "Quality Assurance";
    public static String EditShortname = "QA";
    public static String EditDescribe = "Quality assurance is a broad process for preventing quality failures. The QA team is involved in all stages of a product's development: production, testing, packaging, and delivery.";

    @BeforeClass
    public void beforeMethod() {
        driver = new EdgeDriver();
        driver.get("https://qa-gm3.quaspareparts.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize WebDriverWait with a timeout of 10 seconds
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
        //<add new unit>
        WebElement AddNewUnit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info float-end text-white']")));
        AddNewUnit.click();
        //<write a name>
        WebElement WriteAname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control fw-bold'])[1]")));
        WriteAname.sendKeys(name);
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

        //<successful message appear >
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']")));
        assertTrue(successMessage.isDisplayed(), "Success message is not displayed after adding the unit.");

        //-------------------------------------------------------------------------------------------------------------------

        WebElement ClickOnEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-outline-dark']")));
        ClickOnEdit.click();
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

