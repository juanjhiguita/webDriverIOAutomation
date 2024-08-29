package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebViewScreen extends BaseScreen {
    public WebViewScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String WEBVIEW_TITLE_TXT = "UiSelector().textContains(\"Next-gen browser and mobile automation test framework for Node.js\")";
    @AndroidFindBy(uiAutomator = WEBVIEW_TITLE_TXT)
    private WebElement webViewTitleTxt;

    @AndroidFindBy(accessibility = "Login")
    private WebElement loginMenuBtn;

    public boolean verifyBeOnWebViewScreen() {
        return this.webViewTitleTxt.isDisplayed();
    }

    public boolean isLoginMenuBtnClickeable(){
        return this.loginMenuBtn.isDisplayed();
    }

    public LoginScreen openLoginScreen() {
        this.loginMenuBtn.click();
        return new LoginScreen(driver);
    }
}
