package Salman;

import configration.testconfigng;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_0010 extends testconfigng {

    private void Login() {

        driver.get("https://qa-gm3.quaspareparts.com/");
        By LogginButton = By.className("login-button");
        driver.findElement(LogginButton).click();
        By username = By.id("username");
        By password = By.id("password");
        By LoginButton = By.tagName("button");
        driver.findElement(username).sendKeys("assurewise@assurewise.com");
        driver.findElement(password).sendKeys("EJWO_PWr17ePelV");
        driver.findElement(LoginButton).click();
    }


    @Test
    public void displayed() {
        Login();
     //   By departmentLink= By.id("link6");

        By remotbutton = By.xpath("//a[contains(@href,'#/departments/remote')]");
        wait.until(f -> {
            driver.findElement(remotbutton).getText();
            return true;
        });

        driver.findElement(remotbutton).click();

        By numberOfList = By.xpath("//div[contains(@class,'col-9')]");
        wait.until(f -> {
            driver.findElement(numberOfList).getText();
            return true;
        });
       int   number =  driver.findElements(numberOfList).size();

        Assert.assertTrue(  number >0 ,"the list is availble");


    }


}
