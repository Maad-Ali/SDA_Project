package pages;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Pages{
    public Login(WebDriver driver, ActionsBot bot) {
        super(driver,bot);
    }

    private final String url = "https://qa-gm3.quaspareparts.com/";

    private final By login = By.className("login-button");
    private final By userName = By.id("username");
    private final By userPassword = By.id("password");
    private final By loginButton = By.tagName("button");



    @Step
    public pages.Login toGo(){
        bot.navigate(url);
        return this;
    }

    @Step
    public void login(String username, String pass){
        bot.click(login);
        bot.type(userName, username);
        bot.type(userPassword, pass);
        bot.click(loginButton);

    }
}
