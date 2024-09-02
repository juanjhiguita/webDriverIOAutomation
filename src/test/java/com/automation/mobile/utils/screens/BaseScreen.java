package com.automation.mobile.utils.screens;

import com.automation.mobile.screens.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    protected AndroidDriver driver;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Home")
    private WebElement homeMenuBtn;
    @AndroidFindBy(accessibility = "Webview")
    private WebElement webviewMenuBtn;
    @AndroidFindBy(accessibility = "Login")
    private WebElement loginMenuBtn;
    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsMenuBtn;
    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeMenuBtn;
    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragMenuBtn;


    public WebElement getHomeMenuBtn() {
        return homeMenuBtn;
    }

    public WebElement getWebviewMenuBtn() {
        return webviewMenuBtn;
    }

    public WebElement getLoginMenuBtn() {
        return loginMenuBtn;
    }

    public WebElement getFormsMenuBtn() {
        return formsMenuBtn;
    }

    public WebElement getSwipeMenuBtn() {
        return swipeMenuBtn;
    }

    public WebElement getDragMenuBtn() {
        return dragMenuBtn;
    }

    public HomeScreen openHomeScreen() {
        this.getHomeMenuBtn().click();
        return new HomeScreen(driver);
    }

    public WebviewScreen openWebViewScreen() {
        this.getWebviewMenuBtn().click();
        return new WebviewScreen(driver);
    }

    public LoginScreen openLoginScreen() {
        this.getLoginMenuBtn().click();
        return new LoginScreen(driver);
    }

    public FormsScreen openFormsScreen() {
        this.getFormsMenuBtn().click();
        return new FormsScreen(driver);
    }
    public SwipeScreen openSwipeScreen() {
        this.getSwipeMenuBtn().click();
        return new SwipeScreen(driver);
    }

    public DragScreen openDragScreen() {
        this.getDragMenuBtn().click();
        return new DragScreen(driver);
    }

    public boolean isHomeMenuBtnVisibleAndClickeable(){
        return this.getHomeMenuBtn().isDisplayed() && this.getHomeMenuBtn().getAttribute("clickable").equals("true");
    }

    public boolean isWebviewMenuBtnVisibleAndClickeable(){
        return this.getWebviewMenuBtn().isDisplayed() && this.getWebviewMenuBtn().getAttribute("clickable").equals("true");
    }

    public boolean isLoginMenuBtnVisibleAndClickeable(){
        return this.getLoginMenuBtn().isDisplayed() && this.getLoginMenuBtn().getAttribute("clickable").equals("true");
    }

    public boolean isFormsMenuBtnVisibleAndClickeable(){
        return this.getFormsMenuBtn().isDisplayed() && this.getFormsMenuBtn().getAttribute("clickable").equals("true");
    }

    public boolean isSwipeMenuBtnVisibleAndClickeable(){
        return this.getSwipeMenuBtn().isDisplayed() && this.getSwipeMenuBtn().getAttribute("clickable").equals("true");
    }

    public boolean isDragMenuBtnVisibleAndClickeable(){
        return this.getDragMenuBtn().isDisplayed() && this.getDragMenuBtn().getAttribute("clickable").equals("true");
    }

    public WebDriverWait setUpWait(long time){
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public void waitSomeSeconds(double time){
        try{
            Thread.sleep((long)(time * 1000));
        }catch (InterruptedException ignored){

        }
    }


}
