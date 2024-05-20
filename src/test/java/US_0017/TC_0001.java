package US_0017;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_0001 {




    // Login successfully with valid username and password


    @Test
    public void Login() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qa-gm3.quaspareparts.com/");
        By LogginButton = By.className("login-button");
        driver.findElement(LogginButton).click();
        By username = By.id("username");
        By password = By.id("password");
        By LoginButton = By.tagName("button");
        driver.findElement(username).sendKeys("assurewise@assurewise.com");
        driver.findElement(password).sendKeys("ih_fQsWFd34Shkh");
        driver.findElement(LoginButton).click();

        var title = driver.getTitle();
        Assert.assertEquals("Account Management",title );
    }

    // login with invalid credentials, have message : "Invalid Credentials"


    @Test
    public void Login2() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qa-gm3.quaspareparts.com/");
        By LogginButton = By.className("login-button");
        driver.findElement(LogginButton).click();
        By username = By.id("username");
        By password = By.id("password");
        By LoginButton = By.tagName("button");
        driver.findElement(username).sendKeys("assurewise@as65656surewise.com");
        driver.findElement(password).sendKeys("i6556464644Shkh");
        driver.findElement(LoginButton).click();
        By errormessage =By.xpath("//h5[@class='pb-1 help-block']");
        var errorMessageText = driver.findElement(errormessage).getText();
        Assert.assertEquals("Invalid Credentials", errorMessageText);




    }
    // Verify that an error message is displayed when the user enters an email address in an incorrect format.


    @Test
    public void Login3() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qa-gm3.quaspareparts.com/");
        By LogginButton = By.className("login-button");
        driver.findElement(LogginButton).click();
        By username = By.id("username");
        By password = By.id("password");
        By LoginButton = By.tagName("button");
        driver.findElement(username).sendKeys("assurewise@ass7767575757575urewise.com");
        driver.findElement(password).sendKeys("ih_fQsWFd34Shkh");
        driver.findElement(LoginButton).click();
        By errormessage =By.xpath("//h5[@class='pb-1 help-block']");
        var errorMessageText = driver.findElement(errormessage).getText();
        Assert.assertEquals("Invalid Credentials", errorMessageText);



    }
    // Verify that an error message is displayed when the user enters invalid password


    @Test
    public void Login4() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qa-gm3.quaspareparts.com/");
        By LogginButton = By.className("login-button");
        driver.findElement(LogginButton).click();
        By username = By.id("username");
        By password = By.id("password");
        By LoginButton = By.tagName("button");
        driver.findElement(username).sendKeys("pehicej808@bsomek.com");
        driver.findElement(password).sendKeys("tAORf9zTeyKSP4R");
        driver.findElement(LoginButton).click();
        By errormessage =By.xpath("//h5[@class='pb-1 help-block']");
        var errorMessageText = driver.findElement(errormessage).getText();
        Assert.assertEquals("Invalid Credentials", errorMessageText);



    }
}




