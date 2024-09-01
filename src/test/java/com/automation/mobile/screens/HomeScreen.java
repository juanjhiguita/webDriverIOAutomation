package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {
    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String HOME_TITLE_TXT = "UiSelector().text(\"WEBDRIVER\")";
    @AndroidFindBy(uiAutomator = HOME_TITLE_TXT)
    private WebElement homeTitleTxt;

    public boolean verifyBeOnMainScreen() {
        return this.homeTitleTxt.isDisplayed();
    }

    public boolean isWebViewMenuBtnDisplayed() {
        return this.getWebviewMenuBtn().isDisplayed();
    }

    public WebViewScreen openWebViewScreen() {
        this.getWebviewMenuBtn().click();
        return new WebViewScreen(driver);
    }
}
