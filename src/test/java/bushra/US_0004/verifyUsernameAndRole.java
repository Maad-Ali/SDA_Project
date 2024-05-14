package bushra.US_0004;

import bushra.Us_0003.testconfigng;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class verifyUsernameAndRole  extends testconfigng {
     // US_0003 displayed username and role top of dropdown menu.
     By LogginButton=By.className("login-button");
    By username_role=By.xpath("//span[@class='fw-bold']");
    private void Login(String username, String password){
        driver.get("https://qa-gm3.quaspareparts.com/");
        driver.findElement(LogginButton).click();
        By usernameTextArea = By.id("username");
        By passwordTextArea = By.id("password");
        By loginButton = By.tagName("button");
        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();

    }@Test
    public void verifyUsernameAndRoleDisplayedInDropdown()  {
        Login( "gabana2035@ahieh.com", "Aa1BbCc@");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        String verifyUsernameAndRoleDisplayed= driver.findElement(username_role).getText();
        Assert.assertEquals(verifyUsernameAndRoleDisplayed,"gabana2035@ahieh.com | Business Owner");
        System.out.println("verifyUsernameAndRoleDisplayed");
    }
}
