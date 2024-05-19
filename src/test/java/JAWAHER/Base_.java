package JAWAHER;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_ {
    WebDriver driver;
    Wait<WebDriver> wait;




    protected void ClickTeamsModule(){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='link7']"))).click();;
    }
    protected void Click_AddNewButton (){

        String xpath="//button[contains(@class, 'btn btn-info float-end text-white') and @type='button']";
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

    }

    protected void AddNewTeamMethod() {
        String Name="Quality Assurance 5";
        String ShortcutName="QA 5";

        //Name
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        var Field1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        //wait.pollingEvery(Duration.ofMillis(2000));
        Field1.sendKeys(Name);

        //shortName
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var Field2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("short_name")));
        Field2.sendKeys(ShortcutName);

        //Team Type
        String depType_dropdown_path = "//div[@id='react-select-3-placeholder']";//Locate element by ID
        // Find the dropdown element
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement depType_dropdown =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(depType_dropdown_path)));
        //wait.pollingEvery(Duration.ofMillis(1000));
        depType_dropdown.
                sendKeys("Team", Keys.ENTER);

        //Click Save Button
        var SaveButton = driver.findElement(By.xpath("//button[@class=\"btn btn-info text-white px-3\"]"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SaveButton.click();
    }




//Methods


    protected void EditeATeamClickButton() {
        //Note:-
        //You Have to be in Teams Module
        //Ex:- ClickTeamsModule();

        //1) Click on A team
        WebElement A_Team;
        String El_xpath = "(//a/b)[3]";
        wait = new WebDriverWait(driver, Duration.ofMinutes(3));
        A_Team = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(El_xpath))));
        A_Team.click();

        //2) Edit it
        //Click on Edit Button
        String Edit_xpath = "(//button[@type='button'])[3]";
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Edit_xpath))).click();

        driver.navigate().refresh();
    }

}
