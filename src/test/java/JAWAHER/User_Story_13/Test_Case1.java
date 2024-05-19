package JAWAHER.User_Story_13;
//US_0013 Displays teams in the Teams module
//Description:
//1-Teams Are Displayed and Clickable
//2-Add New Team

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

@Test
public class Test_Case1 {
WebDriver driver;
Wait<WebDriver> wait;

    @BeforeMethod
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Login();
    }
    @AfterMethod
    public void afterEach(){
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
    @Test
    public void DisplayTeams_Test(){


             //Step1: Click On Teams Module
             ClickTeamsModule();
             //Assert Text is Displayed //The Text:"Teams"
             wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             var TeamsModuleTextElement=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[text()='Teams']"))));
             //Asserting
             TeamsModuleTextElement.isDisplayed();


        }


    @Test
    public void AreTeamsClickable_Test(){
        ClickTeamsModule();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

         // click on a team name
         List<WebElement> TeamsToTest= driver.findElements(By.xpath("//a[1]/b"));
         WebElement ATeam= TeamsToTest.get(3);
         ATeam.click();
         //Step3:Assert The Procedure
         String TeamAssert=driver.findElement(By.xpath("//li[@class='breadcrumb-item active']")).getText();
         //Final Step : Actual and Expected result
         Assert.assertEquals(TeamAssert,"Team Detail");//or //Assert.assertTrue(ATeam.isEnabled());


    }


    @Test
    public void AddNewTeam_Test(){
        ClickTeamsModule();

        //getting
        String Path="//a/b";

        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        int listSize_theNew1= wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(Path)))).size();


        Click_AddNewButton();
        AddNewTeamMethod();
        ClickTeamsModule();
        //--------------------------------------------------------------------------

        //getting
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        int listSize_theNew2= wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(Path)))).size();





        Assert.assertEquals((listSize_theNew1+1),listSize_theNew2);

    }





    protected void ClickTeamsModule(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='link7']")));
        // click on the compose button as soon as the "compose" button is visible
        driver.findElement(By.xpath("//li[@id='link7']")).click();
    }

    protected void Click_AddNewButton (){

        String xpath="//button[contains(@class, 'btn btn-info float-end text-white') and @type='button']";

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofMillis(1000));
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

    }
    private void AddNewTeamMethod(){

        //Values for Test
        String Name="Quality Assurance 5";
        String ShortcutName="QA 5";

        //Name
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        var Field1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        Field1.sendKeys(Name);

        //shortName
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var Field2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("short_name")));
        Field2.sendKeys(ShortcutName);

        //Team Type

        String depType_dropdown_path="'react-select-2-input'";
        //Find the dropdown element
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement depType_dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id(depType_dropdown_path)));
        depType_dropdown.sendKeys("Team", Keys.ENTER);

        //Click Save Button

        var SaveButton=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"btn btn-info text-white px-3\"]")));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SaveButton.click();
    }

}