package Enas.US_0005;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TC_0002 {


    protected WebDriver driver;
    protected Wait<WebDriver> wait;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @org.testng.annotations.Test
    public void MembershipLogo() throws InterruptedException {

        driver.get("https://qa-gm3.quaspareparts.com/");
        // Submit the login form
        driver.findElement(By.className("login-button")).click();
        // Find and fill in the username and password fields
        driver.findElement(By.id("username")).sendKeys("pehicej808@bsomek.com");
        driver.findElement(By.id("password")).sendKeys("tAORf9zTeyKSP4R");
        // Submit the sign-in form
        driver.findElement(By.tagName("button")).click();
        //Click on the Navigate to the Memberships module.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Membership = driver.findElement(By.id("link2"));
        Assert.assertTrue(Membership.isDisplayed());
        Membership.click();
        //Click the existed membership to access the membership details.
        WebElement ExistedMembership = driver.findElement(By.className("col-4"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ExistedMembership.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Verfiy the logo is displayed in the Membership Information page.
        WebElement logoElement = driver.findElement(By.xpath("//img[@class='img-fluid rounded']"));

        boolean isLogoDisplayed = logoElement.isDisplayed();
        Assert.assertFalse(isLogoDisplayed, "Logo is visually appearing when it should not be.");

//        if (isLogoDisplayed) {
//            System.out.println("Logo is appearing.");
//        } else {
//            System.out.println("Logo is not appearing.");
//        }
    }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }

}




