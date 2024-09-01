package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebviewScreen extends BaseScreen {
    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String WEBVIEW_TITLE_TXT = "UiSelector().textContains(\"Next-gen browser and mobile automation test framework for Node.js\")";
    @AndroidFindBy(uiAutomator = WEBVIEW_TITLE_TXT)
    private WebElement webViewTitleTxt;

    public WebElement getWebViewTitleTxt() {
        return webViewTitleTxt;
    }

    public boolean verifyBeOnWebViewScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.getWebViewTitleTxt()));
        return this.webViewTitleTxt.isDisplayed();
    }

    public LoginScreen openLoginScreen() {
        this.getLoginMenuBtn().click();
        return new LoginScreen(driver);
    }
}
