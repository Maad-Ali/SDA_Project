package pages;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class Department extends Pages{
    public Department(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }


    private final By departmentLink = By.id("link5");
    private final By departmentList = By.tagName("b");
    private final By rulesList = By.xpath("//div[@class='col-9']");
    private final By loginButton = By.tagName("button");


    @Step
    public void clickDepartmentLink() {
        bot.getText(departmentLink);
        bot.click(departmentLink);
    }

    public boolean isDepartmentLinkDisplayed() {
        bot.displayed(departmentLink);
        return true;
    }

//    @Step
//    public int getDepartmentSize(){
//        bot.getText(departmentList);
//        driver.findElements(departmentList);
//
//        List<WebElement> departments = driver.findElements(departmentList);
//        return departments.size();
//    }

    public List<String> getDepartmentList() {

        bot.getText(departmentList);


        return driver.findElements(departmentList)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getRulesList() {


        return driver.findElements(rulesList)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
