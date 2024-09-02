package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen extends BaseScreen {
    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String HOME_TITLE_TXT = "UiSelector().text(\"WEBDRIVER\")";
    @AndroidFindBy(uiAutomator = HOME_TITLE_TXT)
    private WebElement homeTitleTxt;

    public boolean verifyBeOnMainScreen() {
        WebDriverWait wait = setUpWait(10);
        wait.until(ExpectedConditions.visibilityOf(this.homeTitleTxt));
        return this.homeTitleTxt.isDisplayed();
    }

    public boolean isWebViewMenuBtnDisplayed() {
        return this.getWebviewMenuBtn().isDisplayed();
    }
}
