package Leen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Department;
import pages.Login;

import java.util.List;
import java.util.stream.Collectors;

public class US_0007 extends Tests{
    @Test
    public void passLogin(){
        Login loginPage = new Login(driver , bot);
        loginPage.toGo();
        loginPage.login("pehicej808@bsomek.com", "tAORf9zTeyKSP4R");
        Department departmentPage = new Department(driver , bot);
        departmentPage.clickDepartmentLink();

        Assert.assertTrue(departmentPage.isDepartmentLinkDisplayed());

        List<String> departmentList = departmentPage.getDepartmentList();
        List<String> rulesList = departmentPage.getRulesList();
        int departmentsSize = departmentList.size();
        String departmentsTable = String.join(", ", departmentList);
        String rulesTable = String.join(", ", rulesList);

        Assert.assertFalse(departmentsTable.isEmpty());
        System.out.println(departmentsSize);
        System.out.println(departmentList);
        System.out.println(rulesTable);
    }


}
