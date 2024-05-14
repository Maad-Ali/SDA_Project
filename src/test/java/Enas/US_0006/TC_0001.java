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

public class TC_0001 {


    protected WebDriver driver;
    protected Wait<WebDriver> wait;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @org.testng.annotations.Test
    public void EmptyCompany () {

        driver.get("https://qa-gm3.quaspareparts.com/");
        // Submit the login form
        driver.findElement(By.className("login-button")).click();
        // Find and fill in the username and password fields
        driver.findElement(By.id("username")).sendKeys("pehicej808@bsomek.com");
        driver.findElement(By.id("password")).sendKeys("tAORf9zTeyKSP4R");
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
//        nameField.click();
        // Select the existing text in the input field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        nameField.sendKeys(Keys.CONTROL + "a");
        // Delete the selected text
        nameField.sendKeys(Keys.DELETE);
//        nameField.clear();
        // Locate the input field by its ID and click on it
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement emailField = driver.findElement(By.name("email"));
//        emailField.click();
//        // Select the existing text in the input field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        emailField.sendKeys(Keys.CONTROL + "a");
        // Delete the selected text
        emailField.sendKeys(Keys.DELETE);
//        emailField.clear();


        //Submit the changes to update the company details.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement SaveButton = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        SaveButton.click();

        // Assert that the error message is displayed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement errorMessage = driver.findElement(By.xpath("//span[@class='text-danger']"));
        String expectedErrorMessage = "Please enter a name for company";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not displayed correctly.");

        // Assert that the save button is disabled
        boolean isSaveButtonEnabled = SaveButton.isEnabled();
        Assert.assertEquals(isSaveButtonEnabled, true, "Save button is disabled when fields are empty.");

    }





    @AfterClass
    public void afterMethod() {
       //driver.quit();
    }

}
