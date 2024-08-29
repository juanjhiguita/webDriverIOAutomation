package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {
    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String DRAG_TITLE_TXT = "UiSelector().text(\"Drag and Drop\")";
    @AndroidFindBy(uiAutomator = DRAG_TITLE_TXT)
    private WebElement dragTitleTxt;

    public boolean verifyBeOnDragScreen() {
        return dragTitleTxt.isDisplayed();
    }
}
