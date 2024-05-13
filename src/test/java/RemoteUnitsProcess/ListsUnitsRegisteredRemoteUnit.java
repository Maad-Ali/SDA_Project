package RemoteUnitsProcess;

import configration.testconfigng;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ListsUnitsRegisteredRemoteUnit extends testconfigng {
@Test
    public void displayed()

    {



        driver.navigate().to("https://qa-gm3.quaspareparts.com/a3m/?errorMessage=%5Bauthorization_request_not_found%5D%20#/departments/remote");
       By remotbutton =By.xpath("//tagName[contains(@attribute,'value')]")  ;
driver.findElement(By.id("link6")).click();
    }



}
