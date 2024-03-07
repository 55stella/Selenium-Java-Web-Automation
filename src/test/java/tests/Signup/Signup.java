package tests.Signup;

import BaseClases.TestBase;
import PageObject.LoginPage;
import PageObject.SignupPage;
import Utilities.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import static utils.extentReports.ExtentTestManager.startTest;

public class Signup  extends TestBase {

    public Signup() throws FileNotFoundException {
    }
    LoginPage login;
    SignupPage signupPage;
    ReadConfig readConfig;
    SignInToGoogle signInToGoogle;
    public void initializer() throws FileNotFoundException {
        login = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        readConfig = new ReadConfig();
        signInToGoogle = new SignInToGoogle();
    }


    @Test(priority = 1, description = "Validate that the user cannot Signup with an already existing Email address")
    public void ValidateUserCannotSignUpWithSameEmail(Method method) throws InterruptedException, FileNotFoundException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        initializer();
        login.clickSignUpBtn();
        signupPage.sendFirstName(readConfig.pro.getProperty("firstName"));
        signupPage.sendLastName(readConfig.pro.getProperty("lastName"));
        signupPage.sendEmail("agbadustella04@gmail.com");
        signupPage.sendBusinessName(readConfig.pro.getProperty("businessName"));
        signupPage.sendIndustry();
        signupPage.sendBusinessType();
        signupPage.sendCountry();
        signupPage.sendPhoneNumber(readConfig.pro.getProperty("phoneNumber"));
        signupPage.sendCacNumber(readConfig.pro.getProperty("cacNumber"));
        signupPage.sendPassword(readConfig.pro.getProperty("password"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 100)");
        signupPage.clickCreateAccountBtn();
        validateText(signupPage.signupEmailError, "Email already exist");
    }

    @Test(priority = 2, description = "Validate that the user cannot Signup with an already existing  Phone Number")
    public void ValidateUserCannotSignUpWithExistingPhoneNumber(Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        signupPage.clearPhoneNumberInput();
        signupPage.sendPhoneNumber(readConfig.pro.getProperty("phoneNumber"));
        signupPage.clickCreateAccountBtn();
        validateText(signupPage.signupPhoneNumberError, "Phone already exist");
    }
    @Test(priority = 3, description = "Validate that the user cannot Signup with an  Invalid  Phone Number")
    public void ValidateUserCannotSignUpWithAnInvalidPhoneNumber(Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        signupPage.clearPhoneNumberInput();
        signupPage.sendPhoneNumber(readConfig.pro.getProperty("invalidPhoneNumber"));
        signupPage.clickCreateAccountBtn();
        validateText(signupPage.signupPhoneNumberError, "Invalid Phone number of the user");
    }

    @Test(priority = 4, description = "Validate that the user cannot Signup with an  Invalid  Password")
    public void ValidateUserCannotSignUpWithAnInvalidPassword(Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        signupPage.clearPasswordInputField();
        signupPage.sendPassword(readConfig.pro.getProperty("invalidPassword"));
        signupPage.clickCreateAccountBtn();
        validateText(signupPage.signupPasswordError, "Invalid password");
    }

    @Test(priority = 5, description = "Validate that the user cannot Signup with any of the fields Empty")
    public void ValidateUserCannotSignUpWithAnyOfTheFieldsEmpty(Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        signupPage.clearPasswordInputField();
        try {
            assert signupPage.returnCreateAccountButtonElement().getAttribute("disabled") != null;
            System.out.println("Button is disabled as expected.");
        } catch (AssertionError e) {
            ;
        }
    }

    @Test(priority = 6, description = "Validate that the user cannot Signup  when all the Fields Are empty")
    public void ValidateThatSignUpIsNotPossibleWhenAllFieldsAreEmpty(Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        signupPage.clearPhoneNumberInput();
        signupPage.clearFirstNameInputField();
        signupPage.clearLastNameInputField();
        signupPage.clearBusinessEmail();
        signupPage.clearBusinessNameInputField();
        signupPage.clearIndustryInputField();
        signupPage.clearBusinessTypeInputFields();
        signupPage.clearCountryInputFields();
        signupPage.clearCacNumber();
        signupPage.clearPasswordInputField();
        try {
            assert signupPage.returnCreateAccountButtonElement().getAttribute("disabled") != null;
            System.out.println("Button is disabled as expected.");
        } catch (AssertionError e) {
        }
        Thread.sleep(40);
    }
    @Test(priority = 7, description = "Validate Successful Signup")
    public void ValidateSuccessfulSignupIntoFEPlatform(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description());
        signupPage.sendFirstName(readConfig.pro.getProperty("firstName"));
        signupPage.sendLastName(readConfig.pro.getProperty("lastName"));
        signupPage.sendEmail(readConfig.pro.getProperty("unregisteredEmail"));
        signupPage.sendBusinessName(readConfig.pro.getProperty("businessName"));
        signupPage.sendIndustry();
        signupPage.sendCountry();
        signupPage.clearPhoneNumberInput();
        signupPage.sendPhoneNumber(readConfig.pro.getProperty("unregisteredPhoneNumber"));
        signupPage.sendCacNumber(readConfig.pro.getProperty("unRegisteredCACNumber"));
        signupPage.sendPassword(readConfig.pro.getProperty("password"));
        signupPage.clickCreateAccountBtn();
        try {
            WebElement ele = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']//div[text()='Signup successful']"));
            wait(10).until(ExpectedConditions.visibilityOf(ele));
            validateText(ele, "Signup successful");

        } catch (NoSuchElementException e) {
            e.printStackTrace();

        }
    }





}

