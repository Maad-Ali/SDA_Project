package Enas.US_0006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Keys;


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
    public void UpdateCompany () {

        driver.get("https://qa-gm3.quaspareparts.com/");
        // Submit the login form
        driver.findElement(By.className("login-button")).click();
        // Find and fill in the username and password fields
        driver.findElement(By.id("username")).sendKeys("assurewise@assurewise.com");
        driver.findElement(By.id("password")).sendKeys("EJWO_PWr17ePelV");
        // Submit the sign-in form
        driver.findElement(By.tagName("button")).click();
        // Navigate to the Company module.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement CompanyModule = driver.findElement(By.xpath("//li[@id='link4']"));
        Assert.assertTrue(CompanyModule.isDisplayed());
        CompanyModule.click();
        //Click on the registered company to edit.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Edit = driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
        Edit.click();
        // Locate the input field by its ID and click on it
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.click();
        // Select the existing text in the input field
        nameField.sendKeys(Keys.CONTROL + "a");
        // Delete the selected text
        nameField.sendKeys(Keys.DELETE);
        // Enter a new name for the company in the corresponding field
        nameField.sendKeys("Clarusway Test");
        // Locate the input field by its ID and click on it
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.click();
        // Select the existing text in the input field
        emailField.sendKeys(Keys.CONTROL + "a");
        // Delete the selected text
        emailField.sendKeys(Keys.DELETE);
        // Enter a new name for the company in the corresponding field
        emailField.sendKeys("ClaruswayTest@Test.com");
        //Submit the changes to update the company details.
        WebElement SaveButton = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        SaveButton.click();

        // Verify the updated company information is displayed
        WebElement updatedNameElement = driver.findElement(By.xpath("//input[@name='name']"));
        String updatedName = updatedNameElement.getAttribute("value");
        Assert.assertEquals(updatedName, "Clarusway Test", "Updated name is not displayed correctly.");

        WebElement updatedEmailElement = driver.findElement(By.xpath("//input[@name='email']"));
        String updatedEmail = updatedEmailElement.getAttribute("value");
        Assert.assertEquals(updatedEmail, "ClaruswayTest@Test.com", "Updated email is not displayed correctly.");





    }





@AfterClass
public void afterMethod() {
   driver.quit();
}

}
