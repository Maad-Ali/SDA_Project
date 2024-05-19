package J_User_Story_13;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
public class Test_Case2  {
WebDriver driver;
WebDriverWait wait;
@BeforeClass
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Login();
    }
    @Ignore
    @AfterClass
    public void afterMethod(){
        //driver.quit();
    }

    protected void Login(){
        By LoginButton=By.xpath("//a[@class='login-button']");
        driver.findElement(LoginButton).click();

        By UserName =By.id("username");
        By Password =By.id("password");
        driver.findElement(UserName).sendKeys("assurewise@assurewise.com");
        driver.findElement(Password).sendKeys("LERF6RlSyAbgRHc");
        driver.findElement(By.tagName("button")).click();
    }





@Test(priority =1)
   public void AddNewTeamTest(){
    ClickTeamsModule();
    Click_AddNewButton();
    AddNewTeamMethod();

    //Asserting Teams Successfully Added with Alerts
    Alert alert=driver.switchTo().alert();

    String AlertText= alert.getText(); //| Assertion Message:"New department successfully created"
    String Message="New department successfully created";

    Assert.assertTrue(AlertText.contains(Message));


    }


//Methods


    protected void ClickTeamsModule(){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
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
        // Find the dropdown element
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement depType_dropdown =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(depType_dropdown_path)));
        //wait.pollingEvery(Duration.ofMillis(1000));
        depType_dropdown.
                sendKeys("Team", Keys.ENTER);

        //Click Save Button
        var SaveButton = driver.findElement(By.xpath("//button[@class=\"btn btn-info text-white px-3\"]"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SaveButton.click();
    }


}
