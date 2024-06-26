package Leen;

import engine.ActionsBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
public abstract class Tests {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;
    protected ActionsBot bot;
//    protected static JSONObject testData;

    @BeforeClass
    public static void beforeClass() throws IOException, ParseException {
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(Tests.class.getName());
        //testData =  (JSONObject) new JSONParser().parse( new FileReader("src/test/resources/testData/sample.json", StandardCharsets.UTF_8) );
    }

    @Parameters({ "target-browser" })
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String targetBrowser){
        logger.info("Opening "+targetBrowser+" Browser");

        switch (targetBrowser){
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();

            case "edge" -> driver = new EdgeDriver();
        }

//        driver = new EventFiringDecorator(new CustomListener()).decorate(driver);

        driver.manage().window().maximize();

        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bot = new ActionsBot(driver, wait, logger);// , logger
    }

    @AfterMethod
    public void afterMethod(){
        logger.info("Quitting Browser");
        driver.quit();
    }

}