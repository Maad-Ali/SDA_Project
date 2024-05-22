package Lujain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


public class US_15 {

    WebDriver driver;
    Wait<WebDriver> wait;
    @BeforeClass
    public void BeforeClass () {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

    }

    @Test
    public void Login() throws InterruptedException {

        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        By LoginButton = By.className("login-button");
        driver.findElement(LoginButton).click();
        By Username = By.id("username");
        By Password = By.id("password");
        By SignIn = By.tagName("button");
        driver.findElement(Username).sendKeys("assurewise@assurewise.com");
        driver.findElement(Password).sendKeys("EJWO_PWr17ePelV");
        driver.findElement(SignIn).click();


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By UsersModuleLink= By.id("link8");
        wait.until(f -> {
            driver.findElement(UsersModuleLink).getText();
            return true;
        });

        driver.findElement(UsersModuleLink).click();

        driver.quit();

    }


}