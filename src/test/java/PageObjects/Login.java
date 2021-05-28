package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver localdriver;
     public Login(WebDriver remotedriver) // constructor
    {
        localdriver= remotedriver;
        PageFactory.initElements(remotedriver, this);
    }


    @FindBy(name="email")
    WebElement txtUsername;
    @FindBy(name="pass")
    WebElement txtPassword;
    @FindBy(name="login")
    WebElement btnLogin;
    @FindBy(xpath="//*[@id=\"mount_0_0_ZW\"]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/i")
    WebElement btnGotoLogout;
    @FindBy(xpath="//*[@id=\"mount_0_0_ZW\"]/div/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")
    WebElement btnLogout;


    //Action methods
    public  void setUsername(String username)
    {
        txtUsername.sendKeys(username);
    }
    public  void setPassword(String pwd)
    {
        txtPassword.sendKeys(pwd);
    }
    public  void clickLogin()
    {
        btnLogin.click();
    }

    public  void clicktogotologout()
    {
        btnGotoLogout.click();
    }
    public  void clickLogout()
    {
        btnLogout.click();
    }
}





