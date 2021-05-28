package Utilities;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {

Properties pro ;
    public ReadConfig()
    {

        File src = new File("./Configurations/config.properties");

        try {

            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String getUsername() // method to access data from config file
    {
        //String username1 = pro.getProperty("username");
        return pro.getProperty("username");
    }
    public String geturl()
    {
        //String url1 = pro.getProperty("baseurl");
        return pro.getProperty("baseurl");
    }
    public String getpwd()
    {
        //String pwd11 = pro.getProperty("password");
        return pro.getProperty("password") ;
    }
}
