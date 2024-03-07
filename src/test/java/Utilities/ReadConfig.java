package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    public Properties pro;

    public ReadConfig()
    {
        File src = new File(System.getProperty("user.dir") + "//Configurations//Config.properties");// Creating File object
        try
        {
            // Open FileInputStream and Read data
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis); // Load config.properties file
        }

        catch (Exception e)

        {
            // If config.properties file is not available it will throw an exception
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL() // ok - add new url in config.properties
    {
        String url=pro.getProperty("baseURL"); // Value from config.properties stored in url variable
        return url;
    }

    public String getbrowser()
    {
        String browser=pro.getProperty("browser");
        return browser;
    }
}
