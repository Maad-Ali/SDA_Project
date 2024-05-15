package pages;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewDepartmentPage extends Pages {
    public NewDepartmentPage(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }


    private final By Department_name = By.id("name");
    private final By Department_short_name = By.xpath("//input[@name='short_name']");
    private final By Department_type = By.xpath("(//input[@role='combobox'])[1]");
    private final By Department_description = By.xpath("//input[@name='description']");
    private final By saveButton = By.xpath("(//button[@type='button'])[3]");
    private final By toastfyMsg = By.xpath("//p[text()='New department successfully created']");
    private final By nameMessage = By.xpath("(//span[@class='text-danger'])[1]");

    private final By typeMessage = By.xpath("//span[@class='text-danger']");

    public void fillDepartmentDetails(String name, String shortName, String departmentType, String description) {

        bot.displayed(Department_name);
        bot.type(Department_name, name);
        bot.type(Department_short_name, shortName);
        bot.type(Department_type, departmentType + Keys.ENTER);
        bot.type(Department_description, description);
    }

    public void clickSaveButton() {
        bot.click2(saveButton);
    }

    public String getToastMessage() throws InterruptedException {
        Thread.sleep(3000);
        return bot.getText(toastfyMsg);
    }

    public String getNameErrorMessage() {
        return bot.getText(nameMessage);
    }

    public void enterDepartmentName(String name) {
        bot.type(Department_name,name);
    }

    public String getTypeErrorMessage() {
        return bot.getText(typeMessage);
    }
}
