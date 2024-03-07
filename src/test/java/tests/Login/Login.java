package tests.Login;

import BaseClases.TestBase;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class Login extends TestBase {
    ReadConfig readConfig;
    LoginToDashboard login;
    LoginPage loginPage;


    
    public Login() throws FileNotFoundException {
    }
    public void initializer() throws FileNotFoundException {
        readConfig = new ReadConfig();
         login = new LoginToDashboard();
         loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Validate that user shall be able to open the FrontEdge  application with the correct URL")
    public  void ValidateUsersCanOpenFrontEdgeApplication(Method method) throws FileNotFoundException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        initializer();
        System.out.println(loginPage.welcomeText.getText());
        validateText(loginPage.welcomeText, "Lets get you back");
    }

    @Test(priority = 2, description = "Validate that user is unable to login with correct username and incorrect password")
    public  void ValidateUsersIsUnableToLoginWithCorrectUsernameAndIncorrectPassword(Method method) throws FileNotFoundException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        loginPage.sendEmail(readConfig.pro.getProperty("email"));
        loginPage.sendPassword(readConfig.pro.getProperty("incorrectPassword"));
        loginPage.clickContinueButton();
        validateText(loginPage.invalidPasswordError, "Invalid username or password");
    }

    @Test(priority = 3, description = "Validate that the user is unable to log in with incorrect username and incorrect Password")
    public  void ValidateUsersIsUnableToLoginWithIncorrectUsernameAndIncorrectPassword(Method method) throws FileNotFoundException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        loginPage.clearUsernameField();
        loginPage.sendEmail(readConfig.pro.getProperty("incorrectEmail"));
        loginPage.clearPasswordField();
        loginPage.sendPassword(readConfig.pro.getProperty("incorrectPassword"));
        loginPage.clickContinueButton();
        validateText(loginPage.invalidPasswordError, "Invalid username or password");
    }


    @Test(priority = 4, description = "Validate that the user is unable to log in with  correct email and incorrect Password")
    public  void ValidateUsersIsUnableToLoginWithCorrectEmailAndIncorrectPassword(Method method) throws FileNotFoundException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        loginPage.clearUsernameField();
        loginPage.sendEmail(readConfig.pro.getProperty("email"));
        loginPage.clearPasswordField();
        loginPage.sendPassword(readConfig.pro.getProperty("incorrectPassword"));
        loginPage.clickContinueButton();
        validateText(loginPage.invalidPasswordError, "Invalid username or password");
    }

    @Test(priority = 5, description = "Validate that the user is unable to log in with empty fields for both Username and password")
    public  void ValidateUsersIsUnableToLoginWithEmptyFields(Method method) throws FileNotFoundException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        loginPage.clearUsernameField();
        loginPage.sendEmail("");
        loginPage.clearPasswordField();
        loginPage.sendPassword("");
        loginPage.clickContinueButton();
        validateText(loginPage.invalidPasswordError, "Invalid username or password");
    }

    @Test(priority = 6, description = "Validate Successful login")
    public  void ValidateSuccessfulLogin(Method method) throws FileNotFoundException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        initializer();
        loginPage.clearUsernameField();
        loginPage.sendEmail(readConfig.pro.getProperty("email"));
        loginPage.clearPasswordField();
        loginPage.sendPassword(readConfig.pro.getProperty("password"));
        loginPage.clickContinueButton();
        validateText(loginPage.welcomeMessage, "Welcome"+ " " + readConfig.pro.getProperty("name"));
    }

}
