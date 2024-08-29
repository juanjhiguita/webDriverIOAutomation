package com.automation.mobile.utils.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    protected AndroidDriver driver;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
