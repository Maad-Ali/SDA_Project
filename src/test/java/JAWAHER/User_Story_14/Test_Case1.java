package JAWAHER.User_Story_14;
//US_0014 Edit the teams displayed in the Teams module
/*
Description :
Department name(Required)
Department Type(Required)
delete
 */
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class Test_Case1 {
WebDriver driver;
WebDriverWait wait;

    @BeforeMethod
    public void beforeEach() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        Thread.sleep(Duration.ofSeconds(5));
        Login();
    }

    @AfterClass
    public void afterEach(){
        //driver.quit();
    }
    protected void Login() {
        By LoginButton = By.xpath("//a[@class='login-button']");
        driver.findElement(LoginButton).click();

        By UserName = By.id("username");
        By Password = By.id("password");
        driver.findElement(UserName).sendKeys("assurewise@assurewise.com");
        driver.findElement(Password).sendKeys("LERF6RlSyAbgRHc");
        driver.findElement(By.tagName("button")).click();
    }


    @Test
    public void EditeTeams_Test1() {

        /*
        ---> Ex Desc:- IT departments are responsible for managing the
                 organization's critical apps and communication systems, including email,
                 instant messaging, and video conferencing. IT departments ensure that
                  these systems are available and reliable,and that they are secured against
                  hacking and other cyber threats
        * */

        ClickTeamsModule();
        EditeATeamClickButton();


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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var SaveButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info text-white px-3']")));
        wait.pollingEvery(Duration.ofMillis(1000));
        SaveButton.click();



        //case: Edit the Description    xpath://label[@name="description" and @placeholder='Department Description']
        //** Assert Description Field
        String xpath_DescriptionLabel="//label[@name='description'and@placeholder='Department Description']";
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        String DescriptionLabelText= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath_DescriptionLabel))).getText();

        Assert.assertEquals(DescriptionLabelText,DescriptionText);



    }



@Test
public void EditeTeams_ErrorsTest01(){

    //Step 01:Click on Teams Module
    ClickTeamsModule();
    EditeATeamClickButton();//find a team, clicks on it, then: Click Edit Button

    //Execute Test: Team Name Must Be not Blank
    //--------------
    //Delete The Name
    wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    wait.pollingEvery(Duration.ofMillis(1000));
    var Field1=wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
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
    public void EditeTeams_ErrorsTest02(){

        ///Execute Test: Team Type Must Be not Blank
        //Edite
        ClickTeamsModule();
        EditeATeamClickButton();


        //Remove Team Type
        String xButtonPath="(//div[@class=' css-1xc3v61-indicatorContainer'])[1]";
        wait= new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xButtonPath))).click();

        //Click Button
        var SaveButton=driver.findElement(By.xpath("//button[@class='btn btn-info text-white px-3']"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SaveButton.click();

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




    @Ignore
    @Test
    public void DeleteTeam_Test4(){

        ClickTeamsModule();

        //Count Elements for Later Use
        String Path="//div[@class='col-4']";


        //getting
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        int SizeOfTeamsList1= wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(Path)))).size();


        EditeATeamClickButton();



        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        var Delete=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[5]")));
        Delete.click();


        var Confirm =driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Confirm));
        Confirm.click();



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
        int SizeOfTeamsList2= wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(Path02)))).size();


        //Expected Result
        int ExpectedResult= (SizeOfTeamsList1- 1);

        //Asserting

        Assert.assertEquals(SizeOfTeamsList2,ExpectedResult,"Assertion Test no passed");



        //--------------------------------------------------------------------------


    }










//Methods

    protected void ClickTeamsModule(){

        String TeamsModule_xpath="//li[@id='link7']";
        WebElement TeamsModuleElement;

        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofMillis(1000));
        TeamsModuleElement= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TeamsModule_xpath)));
        TeamsModuleElement.click();
    }


    private void EditeATeamClickButton() {
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
