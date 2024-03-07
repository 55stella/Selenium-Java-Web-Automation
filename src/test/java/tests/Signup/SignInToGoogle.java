package tests.Signup;

import BaseClases.TestBase;
import PageObject.GoogleSignInPage;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.Login.LoginToDashboard;

import java.io.FileNotFoundException;

public class SignInToGoogle  extends TestBase {
    public SignInToGoogle() throws FileNotFoundException {
    }
    GoogleSignInPage googleSignInPage;
    ReadConfig readConfig;
    LoginPage loginPage;
    LoginToDashboard loginToDashboard;
    public void initializer() throws FileNotFoundException {
        googleSignInPage = new GoogleSignInPage(driver);
        readConfig = new ReadConfig();
        loginPage = new LoginPage(driver);
        loginToDashboard = new LoginToDashboard();
    }
     public void loginToConfirmEmail() throws FileNotFoundException {
        initializer();
        driver.get("https://google.com");
        googleSignInPage.clickSignInButton();
        googleSignInPage.sendEmailInput(readConfig.pro.getProperty("unregisteredEmail"));
        googleSignInPage.clickNextBtn();
        googleSignInPage.sendPasswordInputField(readConfig.pro.getProperty("googleEmailPassword"));
        googleSignInPage.clickNextBtn();
         WebElement email = driver.findElement(By.xpath("//span[contains(text(),'The FrontEdge Team')]"));
         email.click();
         validateText(email,"The FrontEdge Team" );
         WebElement confirmationLink = driver.findElement(By.xpath("//a[contains(text(),'Confirm')]"));
         String confirmationUrl = confirmationLink.getAttribute("href");
         driver.get(confirmationUrl);
         loginToDashboard.login(readConfig.pro.getProperty("unregisteredEmail"), readConfig.pro.getProperty("googleEmailPassword"));


     }


}
