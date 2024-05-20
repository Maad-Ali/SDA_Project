package Hadeel.US_0011;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TC_0001 { //commment
    public static String email = "assurewise@assurewise.com";
    public static String password = "K_k-KaarTGk_48c";
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
}