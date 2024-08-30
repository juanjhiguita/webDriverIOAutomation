package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Login / Sign up Form\")")
    private WebElement loginTitleTxt;

    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsMenuBtn;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Sign up\")")
    private WebElement signUpMenuBtn;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInputField;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInputField;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPasswordInputField;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement signUpBtn;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertSignUpTitle;

    @AndroidFindBy(id = "android:id/message")
    private WebElement alertSignUpMessage;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement alertSignUpOKBtn;

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
        return this.loginTitleTxt.isDisplayed();
    }

    public boolean isFormsMenuBtnClickable(){
        return this.formsMenuBtn.isDisplayed();
    }

    public FormsScreen openFormsScreen() {
        this.formsMenuBtn.click();
        return new FormsScreen(driver);
    }

    public boolean isSignUpClickable() {
        return this.signUpMenuBtn.isDisplayed();
    }

    public void openSignUpFormulary() {
        this.signUpMenuBtn.click();
    }

    public void fillSignUpFormulary(String email, String password, String confirmPassowrd) {
        this.emailInputField.sendKeys(email);
        this.passwordInputField.sendKeys(password);
        this.confirmPasswordInputField.sendKeys(confirmPassowrd);
    }

    public void clickSignUpBtn() {
        this.signUpBtn.click();
    }

    public boolean isSignUpMessageEqualsExpected() {
        waitSomeSeconds(10);
        if(this.alertSignUpTitle.isDisplayed() && this.alertSignUpMessage.isDisplayed() && this.alertSignUpOKBtn.isDisplayed()){
            // Asserts para verificar que es lo esperado del mensaje
            this.alertSignUpOKBtn.click();
            return true;
        }else{
            return false;
        }

    }
}
