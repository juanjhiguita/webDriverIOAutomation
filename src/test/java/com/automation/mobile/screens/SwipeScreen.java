package com.automation.mobile.screens;

import com.automation.mobile.utils.others.TestUtil;
import com.automation.mobile.utils.screens.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.rmi.CORBA.Tie;
import javax.rmi.CORBA.Util;
import java.sql.Time;
import java.time.Duration;

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
        WebDriverWait wait = setUpWait(20);
        wait.until(ExpectedConditions.visibilityOf(this.carrouselItem4));
        return carrouselItem4;
    }

    public WebElement getCarrouselItem5() {
        return carrouselItem5;
    }

    public WebElement getCarrousel() {
        return carrousel;
    }

    public boolean isDisplayedCarrouselItem0(){
        try{
            return true;
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }
    }

    public boolean isDisplayedCarrouselItem1(){
        try{
            WebDriverWait wait = setUpWait(10);
            wait.until(ExpectedConditions.visibilityOf(this.carrouselItem1));
            return this.carrouselItem1.isDisplayed();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }

    }
    public boolean isDisplayedCarrouselItem2(){
        try{
            WebDriverWait wait = setUpWait(20);
            wait.until(ExpectedConditions.visibilityOf(this.carrouselItem2));
            return this.carrouselItem2.isDisplayed();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }

    }
    public boolean isDisplayedCarrouselItem3(){
        try{
            WebDriverWait wait = setUpWait(10);
            wait.until(ExpectedConditions.visibilityOf(this.carrouselItem3));
            return this.carrouselItem3.isDisplayed();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }

    }
    public boolean isDisplayedCarrouselItem4(){
        try{
            WebDriverWait wait = setUpWait(10);
            wait.until(ExpectedConditions.visibilityOf(this.carrouselItem4));
            return this.carrouselItem4.isDisplayed();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }

    }
    public boolean isDisplayedCarrouselItem5(){
        try{
            WebDriverWait wait = setUpWait(10);
            wait.until(ExpectedConditions.visibilityOf(this.carrouselItem5));
            return this.carrouselItem5.isDisplayed();
        }catch (NoSuchElementException | TimeoutException e){
            return false;
        }
    }

    public boolean verifyBeOnSwipeScreen() {
        WebDriverWait wait = setUpWait(30);
        wait.until(ExpectedConditions.visibilityOf(this.swipeTitleTxt));
        return this.swipeTitleTxt.isDisplayed();
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



    public void swipeToTheLastCard(Point initPoint, Point endPoint, Duration duration) {
        int index = 0;
        while(index < 4){
            TestUtil.swipe(initPoint,endPoint,duration,driver);
            index = index +1;
        }
    }

    public boolean isTheLast(){
        try{
            this.carrouselItem4.isDisplayed();
            this.carrouselItem3.isDisplayed();
            this.carrouselItem2.isDisplayed();
            this.carrouselItem1.isDisplayed();
            return false;
        }catch (NoSuchElementException | TimeoutException e){
            return true;
        }
    }
}