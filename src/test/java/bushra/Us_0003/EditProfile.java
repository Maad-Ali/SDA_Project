package bushra.Us_0003;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class EditProfile extends testconfigng {
    /*
   US_0004  Edit profile information in profile module.
   Password may contain only uppercase (A-Z) letters, lowercase (a-z) letters, numbers (0-9) and special characters of .@#$%_&
   Password must be between 8 to 20 characters long
   Password must contain at least one uppercase
   Password must contain at least one lowecase
   Password must contain at least one digit
   Password must contain special characters from .@#$%_&
   email cannot be changed
   Username must start with letters (A-Za-z)
   "Username must not end with special characters of .-_
   Username may contain letters (A-Za-z), numbers (0-9), and special characters of -._
   Username cannot be empty
    */

    private void Login(String username, String password){
        By LogginButton=By.className("login-button");
        driver.get("https://qa-gm3.quaspareparts.com/");
        driver.findElement(LogginButton).click();
        By usernameTextArea = By.id("username");
        By passwordTextArea = By.id("password");
        By loginButton = By.tagName("button");
        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();

    }
    @Test
    public void ChangePassword01() throws InterruptedException {
        Login("gabana2035@ahieh.com", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Aa123456-");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Aa123456-");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals( DisplayMessage,"Password may contain only uppercase (A-Z) letters, lowercase (a-z) letters, numbers (0-9), and special characters of .@#$%_&");
        System.out.println(DisplayMessage);
    }
    @Test
    public void ChangePassword02() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa1BbCc@");
//        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Aa123456@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Aa123456@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals( DisplayMessage,"Change password successfully");
        System.out.println(DisplayMessage);
    }
    @Test
    public void ChangePassword03() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa123456@");
//        wait.until(f -> {
//        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Aa1234@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Aa1234@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals( DisplayMessage,"Password must be between 8 to 20 characters long.");
        System.out.println(DisplayMessage);
    }
    @Test
    public void ChangePassword04() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa123456@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Aa12345#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Aa12345#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals( DisplayMessage,"Change password successfully");
        System.out.println(DisplayMessage);
    }
    @Test
    public void ChangePassword05() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa12345#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Aa12345678910111213@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Aa12345678910111213@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals( DisplayMessage,"Change password successfully");
        System.out.println(DisplayMessage);
    }
    @Test
    public void ChangePassword06() throws InterruptedException {
//        Thread.sleep(600);
        Login( "gabana2035@ahieh.com", "Aa12345678910111213@");
//        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Aa123456789101112131415@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Aa123456789101112131415@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(150);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals( DisplayMessage,"Password must be between 8 to 20 characters long.");
        System.out.println( DisplayMessage);
    }
    @Test
    public void ChangePassword07() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa12345678910111213@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("aa12345#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("aa12345#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals( DisplayMessage,"Password must contain at least one uppercase.");
        System.out.println( DisplayMessage);
    }
    @Test
    public void ChangePassword08() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa12345678910111213@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("AA12345#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("AA12345#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals(  DisplayMessage,"Password must contain at least one lowercase.");
        System.out.println( DisplayMessage);
    }
    @Test
    public void ChangePassword09() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa12345678910111213@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Bushraa@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Bushraa@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals(DisplayMessage,"Password must contain at least one digit.");
        System.out.println(DisplayMessage);
    }
    @Test
    public void ChangePassword10() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa12345678910111213@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("12345678@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("12345678@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals(  DisplayMessage,"Password must contain at least one uppercase.");
        System.out.println( DisplayMessage);
    }
    @Test
    public void ChangePassword11() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa12345678910111213@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("AAAAAAAA");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("AAAAAAAA");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals(  DisplayMessage,"Password must contain at least one lowercase.");
        System.out.println( DisplayMessage);
    }
    @Test
    public void ChangePassword12() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa12345678910111213@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("########");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("########");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals(  DisplayMessage,"Password must contain at least one uppercase.");
        System.out.println( DisplayMessage);
    }
    @Test
    public void ChangePassword13() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa12345678910111213@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals( DisplayMessage,"Change password successfully");
        System.out.println(DisplayMessage);
    }
    @Test
    public void ChangePassword14() throws InterruptedException {
        Login("gabana2035@ahieh.com", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("12345678@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("12345678@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals(DisplayMessage, "Password must contain at least one uppercase.");
        System.out.println(DisplayMessage);
    }
    @Test
    public void ChangePassword15() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Aa123456@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Aa1234567@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']"))).getText();
        Assert.assertEquals(  DisplayMessage,"Password and repetition does not match");
        System.out.println( DisplayMessage);
    }
    @Test
    public void verifyEmail()  {
        Login( "gabana2035@ahieh.com", "Aa1BbCc@");
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        String readonlyAttribute = driver.findElement(By.id("email")).getAttribute("gabana2035@ahieh.com");
        Assert.assertNull(readonlyAttribute, "Email field is not read-only.");
        System.out.println(readonlyAttribute);

    }
    @Test
    public void ChangePassword16() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changePasswordButton"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword"))).sendKeys("Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPassword2"))).sendKeys("Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-dark text-white me-2']"))).click();
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger text-white me-2']"))).click();
        String DisplayMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals( DisplayMessage,"The same password used previously");
        System.out.println( DisplayMessage);
    }
    @Test
    public void EditUserName1() throws InterruptedException {
        Login( "gabana2035@ahieh.com", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("1user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(30);
        String ExpectedDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-danger']"))).getText();
        String actualDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, ExpectedDesplayMaseege);
        System.out.println(actualDesplayMaseege);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }
    @Test
    public void EditUserName2() throws InterruptedException {

        Login( "1user", "Aa1BbCc@");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("Bushraa");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(100);
        String actualDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, "User information updated successfully");
        System.out.println(actualDesplayMaseege);
    }
    @Test
    public void EditUserName3() throws InterruptedException {
        Login( "Bushraa", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        Thread.sleep(30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("bushra_");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(100);
        String ExpectedDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-danger']"))).getText();
        String actualDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, ExpectedDesplayMaseege);
        System.out.println(actualDesplayMaseege);
    }
    @Test
    public void EditUserName4() throws InterruptedException {
        //   Thread.sleep(100);
        Login("bushra_", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        Thread.sleep(30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("bushra-");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(100);
        String ExpectedDesplayMaseege = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-danger']"))).getText();
        String actualDesplayMaseege = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, ExpectedDesplayMaseege);
        System.out.println(actualDesplayMaseege);
    }
    @Test
    public void EditUserName5() throws InterruptedException {
        Login( "bushra-", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        Thread.sleep(30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("bushra@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(100);
        String ExpectedDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-danger']"))).getText();
        String actualDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, ExpectedDesplayMaseege);
        System.out.println(actualDesplayMaseege);
    }

    @Test
    public void EditUserName6() throws InterruptedException {
        Login( "bushra@", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        Thread.sleep(30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("bushra.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(100);
        String ExpectedDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-danger']"))).getText();
        String actualDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, ExpectedDesplayMaseege);
        System.out.println(actualDesplayMaseege);
    }

    @Test
    public void EditUserName7() throws InterruptedException {
        Login( "bushra.", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("bushra1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(100);
        String actualDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, "User information updated successfully");
        System.out.println(actualDesplayMaseege);
    }

    @Test
    public void EditUserName8() throws InterruptedException {
        Login( "bushra1", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("bushra_alharbi");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(100);
        String actualDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, "User information updated successfully");
        System.out.println(actualDesplayMaseege);
    }

    @Test
    public void EditUserName9() throws InterruptedException {
        Login( "bushra_alharbi", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("bushra-alharbi");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(100);
        String actualDesplayMaseege= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, "User information updated successfully");
        System.out.println(actualDesplayMaseege);
    }

    @Test
    public void EditUserName10() throws InterruptedException {
        Login("bushra-alharbi", "Aa1BbCc@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("bushra@alharbi");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']"))).click();
        Thread.sleep(100);
        String actualDesplayMaseege = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast fade bg-success border-0 show text-white']"))).getText();
        Assert.assertEquals(actualDesplayMaseege, "User information updated successfully");
        System.out.println(actualDesplayMaseege);
    }
}



