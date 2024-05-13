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

public class TC_0001 {

        protected WebDriver driver;
        protected Wait<WebDriver> wait;


        @BeforeClass
        public void beforeClass() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        @org.testng.annotations.Test
        public void testGoPage() throws InterruptedException {

            driver.get("https://qa-gm3.quaspareparts.com/");
            // Submit the login form
            driver.findElement(By.className("login-button")).click();
            // Find and fill in the username and password fields
            driver.findElement(By.id("username")).sendKeys("pehicej808@bsomek.com");
            driver.findElement(By.id("password")).sendKeys("tAORf9zTeyKSP4R");
            // Submit the sign-in form
            driver.findElement(By.tagName("button")).click();
            //Click on the user information section.
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement UserInfo = driver.findElement(By.className("btn-group"));
            Assert.assertTrue(UserInfo.isDisplayed());
            UserInfo.click();
            //Click on the " My membership" option in the dropdown menu
            WebElement Menu = driver.findElement(By.xpath("//ul[@role='menu']"));
            Assert.assertTrue(Menu.isDisplayed());
            WebElement MemberShips = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='My Memberships']"));
            Assert.assertTrue(MemberShips.isDisplayed());
            MemberShips.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //Click the existed membership to access the membership details.
            WebElement ExistedMembership = driver.findElement(By.className("col-4"));
            Thread.sleep(4000);
            Assert.assertTrue(ExistedMembership.isDisplayed());
            ExistedMembership.click();
            // Assert that the Subscriber  is displayed
            WebElement Subscriber = driver.findElement(By.className("col-md-4"));
            String ExpectedSubscriber = "Subscriber\n" +
                    "pehicej808@bsomek.com";
            String actualSubscriber = Subscriber.getText();
            Assert.assertEquals(actualSubscriber, ExpectedSubscriber, "Subscriber is not displayed correctly.");

        }

        @AfterClass
        public void afterMethod() {
            driver.quit();
        }

    }



