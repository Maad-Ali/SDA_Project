package JAWAHER.User_Story_13;
//US_0013 Displays teams in the Teams module
//Description:
//1-Teams Are Displayed and Clickable
//2-Add New Team

import JAWAHER.Base_;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

@Test
public class Test_Case1 extends Base_ {
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



}