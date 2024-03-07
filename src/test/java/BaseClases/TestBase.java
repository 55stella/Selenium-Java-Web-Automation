package BaseClases;

import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static Properties testdataProperties;
    static ReadConfig readconfig = new ReadConfig();
    public static String baseURL = readconfig.getApplicationURL();

    public String browser = readconfig.getbrowser();
    public static FileInputStream fis;
    public static EdgeOptions handlingSSL1 = new EdgeOptions();
    public static FirefoxOptions handlingSSL2 = new FirefoxOptions();
    public static WebDriver driver;
    public static Logger logger;
    public static ChromeOptions handlingSSL = new ChromeOptions();
    public Alert alert;



   public TestBase() throws FileNotFoundException {
       loadProcFile();
   }

    public void loadProcFile() throws FileNotFoundException {
        testdataProperties = new Properties();
        try {
            fis = new FileInputStream("Configurations/Config.properties");
            testdataProperties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @BeforeClass
    public void setup() {
        {
            if (browser.equalsIgnoreCase("chrome")) {
                    WebDriverManager.chromiumdriver().setup();
                    handlingSSL.setAcceptInsecureCerts(true);
                    driver = new ChromeDriver(handlingSSL);
                } else if (browser.equalsIgnoreCase("edge")) {
                    //Create instance of MSEdgeOptions Class
                    //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
                    handlingSSL1.setAcceptInsecureCerts(true);
                    //Creating instance of Edge driver by passing reference of EdgeOptions object
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(handlingSSL1);
                } else if (browser.equalsIgnoreCase("firefox")) {
                    handlingSSL2.setAcceptInsecureCerts(true);
                    //Creating instance of Firefox driver by passing reference of FirefoxOptions object
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
                    driver = new FirefoxDriver(handlingSSL2);
                }
                System.out.println(baseURL);
                driver.get(baseURL);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//

            }
    }



    public void waitForElement(WebElement element, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Element is not visible: " + element);
        }
    }

    public WebDriverWait wait(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait;
    }



    public void validateText(WebElement element, String message) {
        String actualMessage = "";
        try {
            actualMessage = element.getText();
            System.out.println("The message is: " + actualMessage);
            Assert.assertTrue(actualMessage.contains(message));
        } catch (AssertionError | NoSuchElementException e) {
            throw new AssertionError(e);
        }
    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}


