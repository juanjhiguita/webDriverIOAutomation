package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class SwipeScreen extends BaseScreen {
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String SWIPE_TITLE_TXT = "UiSelector().text(\"Swipe horizontal\")";
    @AndroidFindBy(uiAutomator = SWIPE_TITLE_TXT)
    private WebElement swipeTitleTxt;

    private WebElement PreviousCard;
    private WebElement mainCard;
    private WebElement nextCard;

    @AndroidFindBy(id = "__CAROUSEL_ITEM_0_READY__")
    private WebElement carrouselItem0;

    @AndroidFindBy(id = "__CAROUSEL_ITEM_1_READY__")
    private WebElement carrouselItem1;

    @AndroidFindBy(id = "__CAROUSEL_ITEM_2_READY__")
    private WebElement carrouselItem2;

    @AndroidFindBy(id = "__CAROUSEL_ITEM_3_READY__")
    private WebElement carrouselItem3;

    @AndroidFindBy(id = "__CAROUSEL_ITEM_4_READY__")
    private WebElement carrouselItem4;

    @AndroidFindBy(id = "__CAROUSEL_ITEM_5_READY__")
    private WebElement carrouselItem5;

    @AndroidFindBy(accessibility = "Carousel")
    private WebElement carrousel;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"You found me!!!\")")
    private WebElement youFoundMe;

    public WebElement getYouFoundMe() {
        return youFoundMe;
    }

    public WebElement getCarrouselItem0() {
        return this.carrouselItem0;
    }

    public WebElement getCarrouselItem1() {
        return carrouselItem1;
    }

    public WebElement getCarrouselItem2() {
        return carrouselItem2;
    }

    public WebElement getCarrouselItem3() {
        return carrouselItem3;
    }

    public WebElement getCarrouselItem4() {
        return carrouselItem4;
    }

    public WebElement getCarrouselItem5() {
        return carrouselItem5;
    }

    public WebElement getCarrousel() {
        return carrousel;
    }

    public boolean isDisplayedMainCard(){
        return this.carrouselItem0.isDisplayed();
    }

    public void setCarrouselItem0(WebElement carrouselItem0) {
        this.carrouselItem0 = carrouselItem0;
    }

    public void setCarrouselItem1(WebElement carrouselItem1) {
        this.carrouselItem1 = carrouselItem1;
    }

    public boolean verifyBeOnSwipeScreen() {
        WebDriverWait wait = setUpWait(20);
        wait.until(ExpectedConditions.visibilityOf(this.swipeTitleTxt));
        return this.swipeTitleTxt.isDisplayed();
    }

    public boolean isDragMenuBtnClickable() {
        return this.getDragMenuBtn().isDisplayed();
    }

    public DragScreen openDragScreen() {
        this.getDragMenuBtn().click();
        return new DragScreen(driver);
    }

    public boolean youFoundMeTextIsDisplayed(){
        try {
            WebDriverWait wait = setUpWait(1);
            WebElement youFoundMe = wait.until(ExpectedConditions.visibilityOf(getYouFoundMe()));
            return youFoundMe.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }
}