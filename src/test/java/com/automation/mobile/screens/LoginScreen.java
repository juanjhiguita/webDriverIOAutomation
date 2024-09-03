package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public static String emailRegistered = "";
    public static String passwordRegistered = "";

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Login / Sign up Form\")")
    private WebElement loginTitleTxt;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Sign up\")")
    private WebElement signUpMenuBtn;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Login\")")
    private WebElement loginMenuBtn;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInputField;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInputField;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPasswordInputField;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement signUpBtn;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginBtn;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    private WebElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement alertOKBtn;

    public boolean isEmailFieldVisible() {
        WebDriverWait wait = setUpWait(10);
        wait.until(ExpectedConditions.visibilityOf(this.emailInputField));
        return this.emailInputField.isDisplayed();
    }

    public boolean isConfirmPasswordFieldVisible() {
        WebDriverWait wait = setUpWait(10);
        wait.until(ExpectedConditions.visibilityOf(this.confirmPasswordInputField));
        return this.confirmPasswordInputField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        WebDriverWait wait = setUpWait(20);
        wait.until(ExpectedConditions.visibilityOf(this.passwordInputField));
        return this.passwordInputField.isDisplayed();
    }

    public boolean verifyBeOnLoginScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.loginTitleTxt));
        return this.loginTitleTxt.isDisplayed();
    }

    public boolean isSignUpClickable() {
        WebDriverWait wait = setUpWait(30);
        wait.until(ExpectedConditions.visibilityOf(this.signUpMenuBtn));
        return this.signUpMenuBtn.isDisplayed();
    }

    public boolean isLoginBtnVisible() {
        return this.loginBtn.isDisplayed();
    }

    public void openSignUpFormulary() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.signUpMenuBtn));
        this.signUpMenuBtn.click();
    }

    public void fillSignUpFormulary(String email, String password, String confirmPassowrd) {
        WebDriverWait wait = setUpWait(20);
        wait.until(ExpectedConditions.elementToBeClickable(this.emailInputField));
        wait.until(ExpectedConditions.elementToBeClickable(this.passwordInputField));
        wait.until(ExpectedConditions.elementToBeClickable(this.confirmPasswordInputField));
        this.emailInputField.sendKeys(email);
        emailRegistered = email;
        this.passwordInputField.sendKeys(password);
        passwordRegistered = password;
        this.confirmPasswordInputField.sendKeys(confirmPassowrd);
    }

    public void fillLoginFormulary(String email, String password) {
        this.emailInputField.sendKeys(email);
        this.passwordInputField.sendKeys(password);
    }

    public void clickSignUpBtn() {
        this.signUpBtn.click();
    }

    public void clickLoginBtn() {
        this.loginBtn.click();
    }

    public boolean isSignUpAlertEqualsExpected() {
        WebDriverWait wait = setUpWait(20);
        wait.until(ExpectedConditions.visibilityOf(this.alertTitle));
        wait.until(ExpectedConditions.visibilityOf(this.alertMessage));
        // Verify sign up message
        if(this.alertTitle.getText().equals("Signed Up!") && this.alertMessage.getText().equals("You successfully signed up!")){
            wait.until(ExpectedConditions.elementToBeClickable(this.alertOKBtn));
            this.alertOKBtn.click();
            return true;
        }else{
            return false;
        }
    }

    public boolean isLoginAlertEqualsExpected() {
        WebDriverWait wait = setUpWait(30);
        wait.until(ExpectedConditions.visibilityOf(this.alertTitle));
        wait.until(ExpectedConditions.visibilityOf(this.alertMessage));
        wait.until(ExpectedConditions.visibilityOf(this.alertOKBtn));
        // Verify login message
        if(this.alertTitle.getText().equals("Success") && this.alertMessage.getText().equals("You are logged in!")){
            this.alertOKBtn.click();
            return true;
        }else{
            return false;
        }
    }
}
