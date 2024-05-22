package Jawaher;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Base_Methods {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;


    @BeforeClass
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Login();
    }
    @AfterClass
    public void afterEach(){
        driver.quit();
    }
    protected void Login(){
        String user_name="assurewise@assurewise.com";
        String password="EJWO_PWr17ePelV";
        By LoginButton=By.xpath("//a[@class='login-button']");
        driver.findElement(LoginButton).click();

        By UserName =By.id("username");
        By Password =By.id("password");
        driver.findElement(UserName).sendKeys(user_name);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
    }

    protected void ClickTeamsModule(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='link7']"))).click();;
    }
    protected void Click_AddNewButton (){

        String xpath="//button[contains(@class, 'btn btn-info float-end text-white') and @type='button']";
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

    }

    protected void AddNewTeamMethod() {
        String Name="Quality Assurance 5";
        String ShortcutName="QA 5";

        //Name
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        var Field1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        //wait.pollingEvery(Duration.ofMillis(2000));
        Field1.sendKeys(Name);

        //shortName
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var Field2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("short_name")));
        Field2.sendKeys(ShortcutName);

        //Team Type
        String depType_dropdown_path = "//div[@id='react-select-3-placeholder']";//Locate element by ID
        String ByID="react-select-2-input";
        // Find the dropdown element
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //WebElement depType_dropdown =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(depType_dropdown_path)));
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        WebElement depType_dropdown =fluentWait.until(ExpectedConditions.elementToBeClickable(By.id(ByID)));

        depType_dropdown.
                sendKeys("Team", Keys.ENTER);


        //Click Save Button
        var SaveButton = driver.findElement(By.xpath("//button[@class=\"btn btn-info text-white px-3\"]"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SaveButton.click();
    }



//Methods



    protected void ClickButtonEditeATeam() {
        //Note:-
        //You Have to be in Teams Module
        //Ex:- ClickTeamsModule();

        //1) Click on A team
        WebElement A_Team;
        String El_xpath = "(//a/b)[3]";
        wait = new WebDriverWait(driver, Duration.ofMinutes(3));
        A_Team = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(El_xpath))));
        A_Team.click();

        //2) Edit it
        //Click on Edit Button
        String Edit_xpath = "(//button[@type='button'])[3]";
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Edit_xpath))).click();

        driver.navigate().refresh();
    }




}