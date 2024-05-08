import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Test {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;



    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @org.testng.annotations.Test
    public void testGoPage() {
        driver.get("https://a3m-qa-gm3.quaspareparts.com");
    }


    @AfterClass
    public void afterMethod() {
        driver.quit();
    }



}

