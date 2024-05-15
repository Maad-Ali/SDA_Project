package Asma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class US_0018 {


    ChromeDriver driver = new ChromeDriver();

    protected Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    public void Login() {
        driver.manage().window().maximize();
        driver.get("https://qa-gm3.quaspareparts.com/");
        By LogginButton = By.className("login-button");
        driver.findElement(LogginButton).click();
        By username = By.id("username");
        By password = By.id("password");
        By LoginButton = By.tagName("button");
        driver.findElement(username).sendKeys("pehicej808@bsomek.com");
        driver.findElement(password).sendKeys("tAORf9zTeyKSP4R");
        driver.findElement(LoginButton).click();


    }


    @Test
    public void ListedRoles() {

        Login();
        By Elements = By.id("link9");

        wait.until(f -> {
            driver.findElement(Elements).getText();
            return true;
        });
        driver.findElement(Elements).click();
        By numberOfList = By.xpath("//div[contains(@class,'col-lg-4 col-md-6 col-12 d-grid mb-2')]");
        wait.until(f -> {
            driver.findElement(numberOfList).getText();
            return true;
        });
        int number = driver.findElements(numberOfList).size();
        System.out.println("There are " + number + " roles");

        Assert.assertTrue(number>0);



    }
}
