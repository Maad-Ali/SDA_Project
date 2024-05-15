package Asma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class US_0017 {


    ChromeDriver driver = new ChromeDriver();
    protected Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public void Login() {

        driver.get("https://qa-gm3.quaspareparts.com/");
        By LogginButton = By.className("login-button");
        driver.findElement(LogginButton).click();
        By username = By.id("username");
        By password = By.id("password");
        By LoginButton = By.tagName("button");
        driver.findElement(username).sendKeys("pehicej808@bsomek.com");
        driver.findElement(password).sendKeys("tAORf9zTeyKSP4R");
        driver.findElement(LoginButton).click();

        By Elements = By.xpath("(//li[@class='list-group-item'])[1]");
        wait.until(f -> {

            driver.findElement(Elements).click();
            return true;
        });
    }

    @Test
    public void NewUsers() {

        Login();

        wait.until(webDriver -> {
            driver.get("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/users");

            // Click on Add New Member
            WebElement addNewMemberButton = driver.findElement
                    (By.xpath("//button[@class='btn btn-info btn-sm me-2 text-light float-end'][2]"));
            addNewMemberButton.click();

            try {
                Thread.sleep(2000);}
            catch (InterruptedException e) {
                throw new RuntimeException(e);}

            By selectDepartment = By.xpath("//div[contains(@class,' css-1xc3v61-indicatorContainer')]");
            By selectDepartmentTeam3 = By.xpath("//div[text()='Team3']");
            driver.findElement(selectDepartment).click();
            driver.findElement(selectDepartmentTeam3).click();


            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("Teast@gmail.com");

            // Select role if applicable
            WebElement roleDropdown = driver.findElement(By.id("react-select-3-input"));
            roleDropdown.click();
            By roleDropdownStoreManager = By.xpath("//div[text()='Store Manager']");
            driver.findElement(roleDropdownStoreManager).click();
            By registerButton0 = By.xpath("//button[text()='Register']");

            // Click on Register
            WebElement registerButton = driver.findElement(registerButton0);
            registerButton.click();


            return true;
        });


        // Verify success message
        wait.until(webDriver -> {
            WebElement successMessage = driver.findElement(By.xpath("//strong[contains(@class,'me-auto')]"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String successText = successMessage.getText();
            Assert.assertEquals(successText, "Successful", "Failed to register new user.");

            System.out.println("New user registered successfully!");
            return true;
        });



    }
}
