package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormsScreen extends BaseScreen {
    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String FORMS_TITLE_TXT = "UiSelector().textContains(\"Form components\")";
    @AndroidFindBy(uiAutomator = FORMS_TITLE_TXT)
    private WebElement formsTitleTxt;

    public WebElement getFormsTitleTxt() {
        return formsTitleTxt;
    }

    public boolean verifyBeOnFormsScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.formsTitleTxt));
        return this.formsTitleTxt.isDisplayed();
    }

    public boolean isSwipeMenuBtnClickeable() {
        return getSwipeMenuBtn().isDisplayed();
    }


}
