package tests.Login;

import BaseClases.TestBase;
import PageObject.LoginPage;

import java.io.FileNotFoundException;

public class LoginToDashboard extends TestBase {
    LoginPage loginPage;

    public LoginToDashboard() throws FileNotFoundException {
    }
    public void login(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.sendEmail(email);
        loginPage.sendPassword(password);
        loginPage.clickContinueButton();
    }
}
