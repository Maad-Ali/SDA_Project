package Leen;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Department;
import pages.Login;

import java.util.List;

public class US_0007 extends Tests{
    @Test
    public void passLogin(){
        Login loginPage = new Login(driver , bot);
        loginPage.toGo();
        loginPage.login("assurewise@assurewise.com", "K_k-KaarTGk_48c");
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
