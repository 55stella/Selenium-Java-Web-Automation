package PageObject;

import BaseClases.PageBase;
import BaseClases.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;


public class LoginPage  extends PageBase {
TestBase testBase;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"signin-email\"]")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"signin-password\"]")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\":r2:\"]")
    WebElement continueButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div/div/div[1]/div/h1")
    public WebElement welcomeText;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/div/div[2]")
    public WebElement invalidPasswordError;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/main/div[2]/div/div/div[2]/div[1]/h1")
    public WebElement welcomeMessage;

    @FindBy(xpath ="//*[@id=\"root\"]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/p/span")
    WebElement signupBtn;



    //#----Methods-------
    public void sendEmail(String email){
        sendText(emailInput, email);
    }
    public void sendPassword(String password){
        sendText(passwordInput, password);}
    public  void clickContinueButton(){click(continueButton);}
    public void clearUsernameField(){clearFields(emailInput);}
    public void clearPasswordField(){clearFields(passwordInput);}
    public void clickSignUpBtn(){click(signupBtn);}

}


