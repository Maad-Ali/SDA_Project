package pages;

import engine.ActionsBot;
import org.openqa.selenium.WebDriver;

public abstract class Pages {
    public final WebDriver driver;
    public final ActionsBot bot;

    public Pages(WebDriver driver, ActionsBot bot) {
        this.driver = driver;
        this.bot = bot;
    }
}