package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainScreen extends BaseScreen {
    public MainScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String HOME_TITLE_TXT = "UiSelector().text(\"WEBDRIVER\")";
    @AndroidFindBy(uiAutomator = HOME_TITLE_TXT)
    private WebElement homeTitleTxt;

    @AndroidFindBy(accessibility = "Webview")
    private WebElement webViewMenuBtn;

    @AndroidFindBy(accessibility = "Login")
    private WebElement loginMenuBtn;

    public boolean verifyBeOnMainScreen() {
        return this.homeTitleTxt.isDisplayed();
    }

    public boolean isWebViewMenuBtnDisplayed() {
        return this.webViewMenuBtn.isDisplayed();
    }

    public WebViewScreen openWebViewScreen() {
        this.webViewMenuBtn.click();
        return new WebViewScreen(driver);
    }

    public LoginScreen openLoginScreen() {
        this.loginMenuBtn.click();
        return new LoginScreen(driver);
    }
}
