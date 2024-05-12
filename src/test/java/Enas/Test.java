package Enas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Test {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;




    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }



    @org.testng.annotations.Test
    public void testGoPage() {

        driver.get("https://qa-gm3.quaspareparts.com/");
        // Submit the login form
        driver.findElement(By.className("login-button")).click();
        // Find and fill in the username and password fields
        driver.findElement(By.id("username")).sendKeys("pehicej808@bsomek.com");
        driver.findElement(By.id("password")).sendKeys("tAORf9zTeyKSP4R");
        // Submit the sign-in form
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        // Locate the user information section in the header of the web page.







    }


    @AfterClass
    public void afterMethod() {
       // driver.quit();
    }



}

