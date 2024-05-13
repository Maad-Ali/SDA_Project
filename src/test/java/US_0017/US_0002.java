package US_0017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.function.Function;

public class US_0002 {
    WebDriver driver;
    Wait<WebDriver> wait;

    public void login() {

        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        By LoginButton = By.className("login-button");
        driver.findElement(LoginButton).click();
        By Username = By.id("username");
        By Password = By.id("password");
        By SignIn = By.tagName("button");
        driver.findElement(Username).sendKeys("pehicej808@bsomek.com");
        driver.findElement(Password).sendKeys("tAORf9zTeyKSP4R");
        driver.findElement(SignIn).click();
    }

    @BeforeClass
    public void BeforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

    }

    @Test
    public void Logo() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By logoLink = By.id("root");
        wait.until(f -> {
            driver.findElement(logoLink).getText();
            return true;
        });
        driver.findElement(logoLink).click();

        Thread.sleep(3000);
        By loginTitle = By.tagName("h4");
        String ActualTitle = driver.findElement(loginTitle).getText();
        Assert.assertEquals(ActualTitle, "login");


    }


    @Test
    public void Login1() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By ProfileLink = By.xpath("//a[contains(@href,'#/profile')]");
        wait.until(f -> {
            driver.findElement(ProfileLink).getText();
            return true;
        });
        driver.findElement(ProfileLink).click();

        Thread.sleep(3000);
        By ProfileTitle = By.tagName("h4");
        String ActualTitle = driver.findElement(ProfileTitle).getText();
        Assert.assertEquals(ActualTitle, "My Profile");


    }


    @Test
    public void Login2() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By mysubscriptionLink = By.xpath("//a[contains(@href,'#/mysubscriptions')]");
        wait.until(f -> {
            driver.findElement(mysubscriptionLink).getText();
            return true;
        });
        driver.findElement(mysubscriptionLink).click();

        Thread.sleep(3000);
        By MySubscriptionstitle = By.tagName("h3");
        String ActualTitle = driver.findElement(MySubscriptionstitle).getText();
        Assert.assertEquals(ActualTitle, "My Subscriptions");

    }
    @Test //no
    public void Login3() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By MyMembershipslink = By.xpath("//a[contains(@href,'#/mymemberships')]");
        wait.until(f -> {
            driver.findElement(MyMembershipslink).getText();
            return true;
        });
        driver.findElement(MyMembershipslink).click();

        Thread.sleep(3000);
        By  myMembershiptitle = By.tagName("h3");
        String ActualTitle = driver.findElement(myMembershiptitle).getText();
        Assert.assertEquals(ActualTitle, " My Memberships ");

    }

    @Test //pass
    public void Login4() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By CompanyGrouplink = By.xpath("//a[contains(@href,'#/companygroup')]");
        wait.until(f -> {
            driver.findElement(CompanyGrouplink).getText();
            return true;
        });
        driver.findElement(CompanyGrouplink).click();

        Thread.sleep(3000);
        By   CompanyGroup = By.tagName("h2");
        String ActualTitle = driver.findElement(CompanyGroup).getText();
        Assert.assertEquals(ActualTitle, "Your Company Group");

    }


    @Test //pass
    public void Login5() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By CompanyGrouplink = By.xpath("//a[contains(@href,'#/company/1715254322840616')]");
        wait.until(f -> {
            driver.findElement(CompanyGrouplink ).getText();
            return true;
        });
        driver.findElement(CompanyGrouplink).click();

        Thread.sleep(3000);
        By   Company = By.tagName("h5");
        String ActualTitle = driver.findElement(Company).getText();
        Assert.assertEquals(ActualTitle, "Company Information");

    }



//    #/departments/department

    @Test //pass
    public void Login6() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By CompanyGrouplink = By.xpath("//a[contains(@href,'#/departments/department')]");
        wait.until(f -> {
            driver.findElement(CompanyGrouplink ).getText();
            return true;
        });
        driver.findElement(CompanyGrouplink).click();

        Thread.sleep(3000);
        By  Departmentslink = By.tagName("h3");
        String ActualTitle = driver.findElement(Departmentslink).getText();
        Assert.assertEquals(ActualTitle, "Departments");

    }

    @Test //pass
    public void Login7() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By RemoteUnitslink= By.xpath("//a[contains(@href,'#/departments/remote')]");
        wait.until(f -> {
            driver.findElement(RemoteUnitslink ).getText();
            return true;
        });
        driver.findElement(RemoteUnitslink).click();

        Thread.sleep(3000);
        By  RemoteUnits= By.tagName("h3");
        String ActualTitle = driver.findElement(RemoteUnits).getText();
        Assert.assertEquals(ActualTitle, "Remote Units");

    }

    @Test //pass
    public void Login8() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By Teamslink= By.xpath("//a[contains(@href,'#/departments/team')]");
        wait.until(f -> {
            driver.findElement(Teamslink ).getText();
            return true;
        });
        driver.findElement(Teamslink).click();

        Thread.sleep(3000);
        By  Teams = By.tagName("h3");
        String ActualTitle = driver.findElement(Teams).getText();
        Assert.assertEquals(ActualTitle, "Teams");

    }




    @Test //no
    public void Login9() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By userlink = By.xpath("//a[contains(@href,'#/users')]");
        wait.until(f -> {
            driver.findElement(userlink).getText();
            return true;
        });
        driver.findElement(userlink).click();

        Thread.sleep(3000);
        By user = By.tagName("h3");
        String ActualTitle = driver.findElement(user).getText();
        Assert.assertEquals(ActualTitle, "Emily - All Members (5)");
    }
    @Test //pass
    public void Login10() throws InterruptedException {

        login();


        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
        By Roleslink= By.xpath("//a[contains(@href,'#/roles')]");
        wait.until(f -> {
            driver.findElement(Roleslink).getText();
            return true;
        });
        driver.findElement(Roleslink).click();

        Thread.sleep(3000);
        By  rules= By.tagName("h3");
        String ActualTitle = driver.findElement(rules).getText();
        Assert.assertEquals(ActualTitle, "All Roles");

    }
    @Test //no
    public void Login11() throws InterruptedException {

        login();

        wait = new Wait<WebDriver>() {
            @Override
            public <T> T until(Function<? super WebDriver, T> isTrue) {
                return null;
            }
        };
        Thread.sleep(3000);
//        a[contains(@href,'#/permissions')]
        By  Permissionslink= By.id("link10");
        wait.until(f -> {

            driver.findElement(Permissionslink).getText();
            return true;
        });
        driver.findElement(Permissionslink).click();

        Thread.sleep(3000);
        By   Permissions = By.tagName("h3");
        String ActualTitle = driver.findElement(Permissions).getText();
        Assert.assertEquals(ActualTitle, "All  Permissions");

    }
    @AfterClass

    public void afterclass() {
        //terminating the session
        driver.quit();
    }

}

