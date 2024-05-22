package Jawaher.J_User_Story_13;

//Teams module
//Description:
//1-Teams Are Displayed and Clickable
//2-Add New Team

import Jawaher.Base_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class User_Story_13 extends Base_Methods {


    @Test
    public void TestCase1_IsTeamsDisplayed(){


        //Step1: Click On Teams Module
        ClickTeamsModule();
        //Assert Text is Displayed //The Text:"Teams"
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        var TeamsModuleTextElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Teams']")));
        //Asserting
        TeamsModuleTextElement.isDisplayed();


    }


    @Test
    public void TestCase2_AreTeamsClickable(){
        ClickTeamsModule();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // click on a team name
//         List<WebElement> TeamsToTest=
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[1]/b"))).get(3).click();
//         TeamsToTest.get(3).click();

        //Step3:Assert The Procedure
        String TeamAssert=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='breadcrumb-item active']"))).getText();

        //Final Step : Actual and Expected result
        Assert.assertEquals(TeamAssert,"Team Detail");//or //Assert.assertTrue(ATeam.isEnabled());


    }



    @Test
    public void TesCase3_AddNewTeam(){
        ClickTeamsModule();

        //getting
        String Path="//a/b";

        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        var The_list_1= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath(Path))));
        int ListSize_1=The_list_1.size();

        Click_AddNewButton();
        AddNewTeamMethod();
        ClickTeamsModule();
        //--------------------------------------------------------------------------
//        //Asserting Teams Successfully Added with Alerts
//        Alert alert=driver.switchTo().alert();
//
//        String AlertText= alert.getText(); //| Assertion Message:"New department successfully created"
//        String Message="New department successfully created";
//
//        Assert.assertTrue(AlertText.contains(Message));

        //getting
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        int listSize_theNew2= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath(Path)))).size();


        Assert.assertEquals((ListSize_1+1),listSize_theNew2);

    }


}