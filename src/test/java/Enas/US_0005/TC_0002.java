package Enas.US_0005;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;

public class TC_0002 {


    protected WebDriver driver;
    protected Wait<WebDriver> wait;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @org.testng.annotations.Test
    public void testGoPage() {

    }

}
