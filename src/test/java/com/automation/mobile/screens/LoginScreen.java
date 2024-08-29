package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Login / Sign up Form\")")
    private WebElement loginTitleTxt;

    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsMenuBtn;

    public boolean verifyBeOnLoginScreen() {
        return this.loginTitleTxt.isDisplayed();
    }

    public boolean isFormsMenuBtnClickeable(){
        return this.formsMenuBtn.isDisplayed();
    }

    public FormsScreen openFormsScreen() {
        this.formsMenuBtn.click();
        return new FormsScreen(driver);
    }
}
