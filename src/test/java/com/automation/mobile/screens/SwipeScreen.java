package com.automation.mobile.screens;

import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

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
    private WebElement firstCard;

    @AndroidFindBy(id = "__CAROUSEL_ITEM_1_READY__")
    private WebElement secondCard;

    @AndroidFindBy(accessibility = "Carousel")
    private WebElement carrousel;

    public WebElement getFirstCard() {
        return this.firstCard;
    }

    public WebElement getCarrousel() {
        return carrousel;
    }

    public boolean isDisplayedMainCard(){
        return this.firstCard.isDisplayed();
    }

    public void setFirstCard(WebElement firstCard) {
        this.firstCard = firstCard;
    }

    public WebElement getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(WebElement secondCard) {
        this.secondCard = secondCard;
    }

    public boolean verifyBeOnSwipeScreen() {
        WebDriverWait wait = setUpWait(10);
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

    public void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 1);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(0));
        /*++if (isAndroid) {
            duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
        } else {
            swipe.addAction(new Pause(input, duration));
            duration = Duration.ZERO;
        }*/
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(0));

        this.driver.perform(Collections.singletonList(swipe));
    }


    public boolean verifyIsTheLastCard() {
        if(secondCard == null){
            return true;
        }

        WebElement titleTextMainCard = firstCard.findElement(new AppiumBy.ByAndroidUIAutomator(
                "EXTENDABLE"));
        return false;
    }
}
