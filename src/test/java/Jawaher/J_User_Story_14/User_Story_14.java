package Jawaher.J_User_Story_14;
import Jawaher.Base_Methods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.NoSuchElementException;

public class User_Story_14 extends Base_Methods {
    @Test
    public void TestCase1_EditeTeams() {

        /*
        ---> Ex Desc:- IT departments are responsible for managing the
                 organization's critical apps and communication systems, including email,
                 instant messaging, and video conferencing. IT departments ensure that
                  these systems are available and reliable,and that they are secured against
                  hacking and other cyber threats
        * */

        ClickTeamsModule();
        ClickButtonEditeATeam();


        //Description
        String DescriptionText="Quality assurance (QA) is the term used in both" +
                " manufacturing and service industries,describes the systematic" +
                "efforts taken to assure that the product(s) delivered to customer(s)" +
                " meet with agree performance,design,expectations.";

        //Description Field
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        var DescriptionField =wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@name='description' and @placeholder='Department Description']"))));
        DescriptionField.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        DescriptionField.sendKeys(DescriptionText);


        //Team Type
        String depType_dropdown_path ="react-select-2-input" ;//Locate element by ID
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        var depType_dropdown =wait.until(ExpectedConditions.elementToBeClickable(By.id(depType_dropdown_path)));
        depType_dropdown.sendKeys("Team",Keys.ENTER);


        //Save Button
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        var SaveButton=fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info text-white px-3']")));
        SaveButton.click();



        //** Assert Description Field
        String xpath_DescriptionLabel="//label[@name='description'and@placeholder='Department Description']";
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        String DescriptionLabelText= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_DescriptionLabel))).getText();

        Assert.assertEquals(DescriptionLabelText,DescriptionText);


    }


    @Test
    public void TestCase2_NameIsRequired(){
//The Purpose of this:  checking the Team Name ,should Be not Blank

        //Step 01:Click on Teams Module
        ClickTeamsModule();
        ClickButtonEditeATeam();//find a team, clicks on it, then: Click Edit Button

        //Execute Test: Team Name Must Be not Blank
        //--------------
        //Delete The Name
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class);

        var Field1=fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
        Field1.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        Field1.clear();

        //Type Team
        String depType_dropdown_path = "react-select-2-input";//Locate element by ID
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement depType_dropdown= wait.until(ExpectedConditions.elementToBeClickable(By.id(depType_dropdown_path)));
        depType_dropdown.sendKeys("Team", Keys.ENTER);

        //Click Button
        var SaveButton=driver.findElement(By.xpath("//button[@class='btn btn-info text-white px-3']"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SaveButton.click();

        ///Assertions
        String ExpectedMessage="Please enter a name for department";
        var ActualMessage= driver.findElement(By.xpath("(//span[@class='text-danger'])[1]")).getText();

        Assert.assertEquals(ActualMessage,(ExpectedMessage),"Not working OMG");

    }


    @Test
    public void TestCase3_TeamTypeIsRequired(){

        ///Execute Test: Team Type Must Be not Blank
        //Edite
        ClickTeamsModule();
        ClickButtonEditeATeam();


        //Remove Team Type
        String xButtonPath="(//div[@class=' css-1xc3v61-indicatorContainer'])[1]";
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xButtonPath))).click();

        //Click Button


        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info text-white px-3']"))).click();


        //Assertions Step

        String xpath="(//span[@class='text-danger'])[1]";


        //Assertion Step
        //element
        var ActualMessageElement= driver.findElement(By.xpath(xpath)).getText();
        //Message
        String ExpectedAssertionMessage ="Please select a type for department";
        //Asserting
        Assert.assertEquals(ActualMessageElement,ExpectedAssertionMessage,"Not working OMG");
    }





    @Test
    public void TestCase4_DeleteTeamTest(){

        ClickTeamsModule();

        //Count Elements for Later Use
        String Path="//div[@class='col-4']";


        //getting
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        int SizeOfTeamsList1= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Path))).size();


        ClickButtonEditeATeam();



        //Click Delete
        //Fluent Wait
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Delete Department']"))).click();
        //Click Confirm

        FluentWait<WebDriver> fluentWait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class);
        String Confirm="//button[text()='Confirm']";

        var confirmButton= fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Confirm)));
        confirmButton.click();


        // wait website at Departments page
        String Edit_xpath = "(//button[@type='button'])[3]";
        String xpath_TitleDep="//h3[text()='Departments']";
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_TitleDep)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Edit_xpath)));

        //Back to Teams
        ClickTeamsModule();

        //Assert the Delete
        //--------------------------------------------------------------------------
        //count of El
        String Path02="//div[@class='col-4']";
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        int SizeOfTeamsList2= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Path02))).size();


        //Expected Result
        int ExpectedResult= (SizeOfTeamsList1- 1);

        //Asserting

        Assert.assertEquals(SizeOfTeamsList2,ExpectedResult,"Assertion Test no passed");



        //--------------------------------------------------------------------------


    }

}
