package Salman;

import configration.testconfigng;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class US_0009 extends testconfigng {
    //name and type required and can be changed
    //can be deleted
    By editdepatmentName = By.id("name");
    By editdepatmentType = By.xpath("(//div[@class=' css-19bb58m'])[1]");
    //div[contains(@class,' css-19bb58m')][1]
    By editdepatmentTypeChoose = By.xpath("//div[text()='Remote Unit']");
    By departmentLink = By.id("link6");
    By editButton = By.xpath("//button[contains(@class,'btn btn-info float-end text-white')]");
    By SaveButton = By.xpath("//button[contains(@class,'btn btn-info text-white px-3')]");
    String url = "https://qa-gm3.quaspareparts.com/a3m/#/department/1715254322840616/1859";

    // delete test BY
    By deleteButton = By.xpath("//button[contains(@class,'btn btn-danger text-light fw-bold float-end')]");
    By deleteButtonConfirm = By.xpath("//button[text()='Confirm']");
    By numberOfList = By.xpath("//div[@class='col-9']");
    int i;
    By listdepartment = By.xpath("((//div[@class='row'])[4]//div[@class='row']//div[@class='col-9'])[" + i + "]//b");

    Boolean result = false;

    private void Login() {
        driver.navigate().to("https://qa-gm3.quaspareparts.com/");
        By LoginButton = By.className("login-button");
        driver.findElement(LoginButton).click();
        By Username = By.id("username");
        By Password = By.id("password");
        By SignIn = By.tagName("button");
        driver.findElement(Username).sendKeys("assurewise@assurewise.com");
        driver.findElement(Password).sendKeys("K_k-KaarTGk_48c");
        driver.findElement(SignIn).click();
    }



    @Test
    public void checkNameAndType() throws InterruptedException {
        // user will log in to the system
        Login();
        // click on department link

        wait.until(f -> {
            driver.findElement(departmentLink).getText();
            return true;
        });
        driver.findElement(departmentLink).click();
        // go to specific department
        driver.get(url);
        Thread.sleep(3000);
        // click on edit button
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        driver.findElement(editButton).click();
        driver.navigate().refresh();
        Thread.sleep(6000);
        //edit department name
        wait.until(webDriver -> {

            driver.findElement(editdepatmentName).clear();
            driver.findElement(editdepatmentName).sendKeys("test");
            return true;
        });


        // choose department type
        WebElement selectDeptTypeDropdown = wait.until
                (ExpectedConditions.elementToBeClickable
                        (editdepatmentType));
        selectDeptTypeDropdown.click();
        WebElement optionTeam = wait.until(ExpectedConditions.elementToBeClickable
                (editdepatmentTypeChoose));
        optionTeam.click();
        Thread.sleep(3000);
        // click on save button
        driver.findElement(SaveButton).click();
        Thread.sleep(3000);
        // assert department name
        By DepLabel = By.id("name");
        String departmentName = driver.findElement(DepLabel).getText();
        Assert.assertEquals(departmentName, "test");
        Thread.sleep(3000);
        // assert department type
        By DepType = By.name("group_type_id");
        String getDepartmentType = driver.findElement(DepType).getText();
        Assert.assertEquals(getDepartmentType, "Remote Unit");
        Thread.sleep(3000);

    }

    @Test
    public void deleteDepartment() throws InterruptedException {
        Thread.sleep(6000);
        Login();
        driver.get(url);

        wait.until(webDriver -> {
            driver.findElement(editButton).click();
            driver.navigate().refresh();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return true;
        });
        driver.navigate().refresh();
        wait.until(webDriver -> {
            driver.findElement(deleteButton).click();
            driver.findElement(deleteButtonConfirm).click();
            return true;
        });


//
        int number1 = driver.findElements(numberOfList).size();
        for ( i = 1; i <= number1; i++) {
            Thread.sleep(3000);
            List<WebElement> allListofNoPriority = driver.findElements(listdepartment);
            for (WebElement element : allListofNoPriority) {

                if (element.getText() != "salman") {
                    System.out.println("Test case should be pass");
                    result = true;

                    System.out.println(element.getText());
                } else {
                    System.out.println("Test case should be fail.");
                }
                Assert.assertTrue(result, "department is not deleted");
            }
        }



    }


}



