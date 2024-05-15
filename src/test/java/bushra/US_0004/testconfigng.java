package bushra.US_0004;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public abstract class testconfigng {

        protected WebDriver driver;
        protected Wait<WebDriver> wait;

        @Parameters({ "target-browser" })
        @BeforeMethod
        public void beforeClass(@Optional("chrome") String targetBrowser){
            switch (targetBrowser){
                case "chrome" -> driver = new ChromeDriver();
                case "firefox" -> driver = new FirefoxDriver();
                case "edge" -> driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        }
        @AfterMethod
        public void AfterMethod(){
            // logger.info("Quitting Browser");
            driver.quit();
        }

    }

