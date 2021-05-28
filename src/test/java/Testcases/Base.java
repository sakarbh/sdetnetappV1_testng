package Testcases;

import Utilities.ReadConfig;
import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class Base {

    ReadConfig r = new ReadConfig();
    public String baseurl = r.geturl();
    public String username =r.getUsername();// reading data from readconfig class
    public String password =r.getpwd();
    public static WebDriver driver;


    @Parameters("browser")

    @BeforeClass// this will execute before every class
    public void setup(String brw) throws InterruptedException {

        if(brw.equals("chrome"))
        {
           System.setProperty("webdriver.chrome.driver", "C://Users//sakbhard//Documents//Selenium//chromedriver_win32//chromedriver.exe");
           driver = new ChromeDriver();
        }
        else if(brw.equals("mozilla"))
        {
            System.setProperty("webdriver.gecko.driver", "C://Users//sakbhard//Documents//Selenium//geckodriver.exe");
            driver = new FirefoxDriver();

        }


    }
    @AfterClass
    public void teardown()
    {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/" +tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");

    }
}
