package PageObject;

import BaseClases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static BaseClases.TestBase.driver;

public class SignupPage  extends PageBase {
    public SignupPage(WebDriver driver) {
        super(driver);
    }
 List <WebElement> options;

    @FindBy(xpath = "//*[@id=\"siginup-firstname\"]")
    WebElement  firstNameInputField;
    @FindBy(xpath = "//*[@id=\"siginup-lastname\"]")
    WebElement lastNameInputField;
    @FindBy(xpath = "//*[@id=\"signup-email\"]")
    WebElement emailInputField;
    @FindBy(xpath = "//*[@id=\"siginup-companyname\"]")
    WebElement businessNameInputField;
    @FindBy(xpath = "//*[@id=\"signup-corporateIndustryId\"]")
    WebElement selectIndustry;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div/form/div[9]")
    WebElement createAccountButton;
    @FindBy(xpath = "//*[@id=\"signup-businessTypes\"]")
    WebElement businessTypeInputField;
    @FindBy(xpath = "//*[@id=\"signup-countryId\"]")
    WebElement countryInputField;
    @FindBy(xpath = "//*[@id=\"siginup-phoneNumber\"]")
    WebElement phoneNumberInputField;
    @FindBy(xpath = "//*[@id=\"siginup-rcNumber\"]")
    WebElement cacInputField;
    @FindBy(xpath = "//*[@id=\"signup-password\"]")
    WebElement passwordInputField;
    @FindBy(xpath = "//*[@id=\"signup-email-helper-text\"]")
    public WebElement signupEmailError;
    @FindBy(xpath = "//*[@id=\"siginup-phoneNumber-helper-text\"]")
    public WebElement signupPhoneNumberError;
    @FindBy(xpath = "//*[@id=\"signup-password-helper-text\"]")
    public WebElement signupPasswordError;
    @FindBy(xpath = "//*[@id=\"3\"]/div[1]/div[2]")
    public WebElement signupSuccessMessage;





// ---methods ---
    public void sendFirstName(String firstName){sendText(firstNameInputField, firstName);}
    public void sendLastName(String lastName){sendText(lastNameInputField,lastName );}
    public void sendEmail(String email){sendText(emailInputField, email);}
    public void sendBusinessName(String businessEmail){sendText(businessNameInputField, businessEmail);}
    public void sendPhoneNumber(String phoneNumber){sendText(phoneNumberInputField, phoneNumber);}
    public void sendCacNumber(String cac){sendText(cacInputField, cac);}
    public void clickCreateAccountBtn(){click(createAccountButton);}
    public void  sendPassword(String password){sendText(passwordInputField, password);}

    public void sendIndustry(){
        click(selectIndustry);
         options = driver.findElements(By.xpath("//ul[@id='signup-corporateIndustryId-listbox']/li"));
        click(options.get(0));
    }

    public void sendBusinessType(){
        click(businessTypeInputField);
        options = driver.findElements(By.xpath("//ul[@id='signup-businessTypes-listbox']/li"));
        click(options.get(0));
    }
    public  void sendCountry(){
        click(countryInputField);
        options = driver.findElements(By.xpath("//ul[@id='signup-countryId-listbox']/li"));
        click(options.get(0));
    }

    // --- Clear input methods---

    public void clearPhoneNumberInput(){clearFields(phoneNumberInputField);}
    public void clearPasswordInputField(){clearFields(passwordInputField);}
    public void clearCacNumber(){clearFields(cacInputField);}
    public  void clearBusinessEmail(){clearFields(emailInputField);}
    public  void clearFirstNameInputField(){clearFields(firstNameInputField);}
    public void clearCountryInputFields(){clearFields(countryInputField);}
    public void clearBusinessTypeInputFields(){clearFields(businessTypeInputField);}
    public void clearBusinessNameInputField(){clearFields(businessNameInputField);}
    public void clearLastNameInputField(){clearFields(lastNameInputField);}
    public void clearIndustryInputField(){clearFields(selectIndustry);}

    public  WebElement returnCreateAccountButtonElement(){return createAccountButton;}


}
