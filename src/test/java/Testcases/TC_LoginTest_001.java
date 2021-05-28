package Testcases;


import PageObjects.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.IOException;

public class TC_LoginTest_001 extends Base {


    @Test
    public void loginTest() throws InterruptedException, IOException {
        driver.get(baseurl);
        Login a = new Login(driver);
       // driver.findElement(By.)
        //Thread.sleep(10000);
        a.setUsername(username);
        //Thread.sleep(100);
        a.setPassword(password);
       // Thread.sleep(10000);
        a.clickLogin();
        Thread.sleep(10000);
        String strtitle = driver.getTitle();
        Thread.sleep(1000);
        if (strtitle.equals("(20+) Facebook"))

        {
           Assert.assertTrue(true);
        }
        else
       {
           captureScreen(driver,"Login test_TC001");
           Assert.assertTrue(false);

        }

    }
}
