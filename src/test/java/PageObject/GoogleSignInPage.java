package PageObject;

import BaseClases.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;

public class GoogleSignInPage  extends PageBase {
    public GoogleSignInPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"gb\"]/div/div[2]/a")
    WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    WebElement emailInputField;
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button")
    WebElement nextBtn;
    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    WebElement passwordInputField;



    // ---methods

    public void clickSignInButton(){click(signInButton);}
    public void sendEmailInput(String email){sendText(emailInputField,email);}
    public void sendPasswordInputField(String password){sendText(passwordInputField, password);}
    public void clickNextBtn(){click(nextBtn);}


}
