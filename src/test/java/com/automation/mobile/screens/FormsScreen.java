package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsScreen extends BaseScreen {
    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String FORMS_TITLE_TXT = "UiSelector().text(\"Forms components\")";
    @AndroidFindBy(uiAutomator = FORMS_TITLE_TXT)
    private WebElement formsTitleTxt;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeMenuBtn;

    public boolean verifyBeOnFormsScreen() {
        return this.formsTitleTxt.isDisplayed();
    }

    public boolean isSwipeMenuBtnClickeable() {
        return this.swipeMenuBtn.isDisplayed();
    }

    public SwipeScreen openSwipeScreen() {
        this.swipeMenuBtn.click();
        return new SwipeScreen(driver);
    }
}
