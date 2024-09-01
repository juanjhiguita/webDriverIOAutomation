package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragScreen extends BaseScreen {
    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String DRAG_TITLE_TXT = "UiSelector().text(\"Drag and Drop\")";
    @AndroidFindBy(uiAutomator = DRAG_TITLE_TXT)
    private WebElement dragTitleTxt;

    public boolean verifyBeOnDragScreen() {
        WebDriverWait wait = setUpWait(10);
        wait.until(ExpectedConditions.visibilityOf(this.dragTitleTxt));
        return dragTitleTxt.isDisplayed();
    }
}
