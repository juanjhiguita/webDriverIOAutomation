package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String SWIPE_TITLE_TXT = "UiSelector().text(\"Swipe horizontal\")";
    @AndroidFindBy(uiAutomator = SWIPE_TITLE_TXT)
    private WebElement swipeTitleTxt;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragMenuBtn;

    public boolean verifyBeOnSwipeScreen() {
        return this.swipeTitleTxt.isDisplayed();
    }

    public boolean isDragMenuBtnClickeable() {
        return this.dragMenuBtn.isDisplayed();
    }

    public DragScreen openDragScreen() {
        this.dragMenuBtn.click();
        return new DragScreen(driver);
    }
}
