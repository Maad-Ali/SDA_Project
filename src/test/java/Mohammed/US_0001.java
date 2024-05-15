package Mohammed;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class US_0001 {


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
      driver.findElement(password).sendKeys("xM8R_D-CIqJRqbi");
      driver.findElement(LoginButton).click();

   }
}
