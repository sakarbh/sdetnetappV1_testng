package Testcases;

import PageObjects.Login;
import Utilities.XLUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDataDriven_TC002 extends Base{




    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {


    Login l = new Login(driver);
    l.setUsername(user);
    l.setPassword(pwd);
    l.clickLogin();
    Thread.sleep(1000);
    if(driver.getTitle().equals("(20+) Facebook"))
    {
        Assert.assertTrue(true);
        Thread.sleep(1000);
        l.clicktogotologout();
        l.clickLogout();

    }
    else
    {
        Assert.assertTrue(false);
    }


    }
    @DataProvider(name = "LoginData")
    String[][] getData() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/java/TestData/LoginData.xlsx";
        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
        String logindata[][] = new String[rownum][colcount];

        for (int i = 1;i<= rownum; i++) {
            for (int j = 0;j<colcount;j++)
            {
                logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
    return logindata;
}}
