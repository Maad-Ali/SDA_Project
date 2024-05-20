package Leen;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Department;
import pages.Login;
import pages.NewDepartmentPage;

import java.util.List;

public class US_0008 extends Tests {
    @Test
    public void addNewDepartment() throws InterruptedException {

        Login loginPage = new Login(driver, bot);
        loginPage.toGo();
        loginPage.login("assurewise@assurewise.com", "K_k-KaarTGk_48c");

        Department departmentPage = new Department(driver, bot);
        departmentPage.clickDepartmentLink();
        departmentPage.clickAddNewDepartment();

        NewDepartmentPage newDepartmentPage = new NewDepartmentPage(driver, bot);
        newDepartmentPage.fillDepartmentDetails("test", "test", "Department", "test");
        newDepartmentPage.clickSaveButton();

        String actual = newDepartmentPage.getToastMessage();
        Assert.assertEquals(actual, "New department successfully created");

        departmentPage.clickDepartmentLink();

        List<String> departmentList = departmentPage.getDepartmentList();
        String departmentsTable = String.join(", ", departmentList);
        System.out.println(departmentsTable);
        Assert.assertTrue(departmentsTable.contains("hello"));

    }

    @Test
    public void failedAddNewDepartment() {
        Login loginPage = new Login(driver, bot);
        loginPage.toGo();
        loginPage.login("pehicej808@bsomek.com", "tAORf9zTeyKSP4R");

        Department departmentPage = new Department(driver, bot);
        departmentPage.clickDepartmentLink();
        departmentPage.clickAddNewDepartment();

        NewDepartmentPage newDepartmentPage = new NewDepartmentPage(driver, bot);
        newDepartmentPage.clickSaveButton();

        String actualNameError = newDepartmentPage.getNameErrorMessage();
        Assert.assertEquals(actualNameError, "Please enter a name for department");

        newDepartmentPage.enterDepartmentName("test");
        newDepartmentPage.clickSaveButton();

        String actualTypeError = newDepartmentPage.getTypeErrorMessage();
        Assert.assertEquals(actualTypeError, "Please select a type for department");
    }
}



