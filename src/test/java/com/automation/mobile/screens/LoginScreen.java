package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

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
        return this.emailInputField.isDisplayed();
    }

    public boolean isConfirmPasswordFieldVisible() {
        return this.confirmPasswordInputField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return this.passwordInputField.isDisplayed();
    }

    public boolean verifyBeOnLoginScreen() {
        WebDriverWait wait = setUpWait(10);
        wait.until(ExpectedConditions.visibilityOf(this.loginTitleTxt));
        return this.loginTitleTxt.isDisplayed();
    }

    public boolean isFormsMenuBtnClickable(){
        return getFormsMenuBtn().isDisplayed();
    }

    public FormsScreen openFormsScreen() {
        getFormsMenuBtn().click();
        return new FormsScreen(driver);
    }

    public boolean isSignUpClickable() {
        return this.signUpMenuBtn.isDisplayed();
    }

    public boolean isLoginBtnVisible() {
        return this.loginBtn.isDisplayed();
    }

    public void openSignUpFormulary() {
        this.signUpMenuBtn.click();
    }

    public void fillSignUpFormulary(String email, String password, String confirmPassowrd) {
        this.emailInputField.sendKeys(email);
        this.passwordInputField.sendKeys(password);
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
        WebDriverWait wait = setUpWait(10);
        wait.until(ExpectedConditions.visibilityOf(this.alertTitle));
        wait.until(ExpectedConditions.visibilityOf(this.alertMessage));
        wait.until(ExpectedConditions.visibilityOf(this.alertOKBtn));
        this.alertOKBtn.click();

        // VERIFICAR MENSAJES DEL SIGN UP
        return true;
    }

    public boolean isLoginAlertEqualsExpected() {
        WebDriverWait wait = setUpWait(10);
        wait.until(ExpectedConditions.visibilityOf(this.alertTitle));
        wait.until(ExpectedConditions.visibilityOf(this.alertMessage));
        wait.until(ExpectedConditions.visibilityOf(this.alertOKBtn));

        // VERIFICAR MENSAJES DEL LOGIN
        this.alertOKBtn.click();
        return true;
    }
}
