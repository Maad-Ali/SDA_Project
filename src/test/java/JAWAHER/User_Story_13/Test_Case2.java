package JAWAHER.User_Story_13;
import JAWAHER.Base_;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
public class Test_Case2  extends Base_ {
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

}
