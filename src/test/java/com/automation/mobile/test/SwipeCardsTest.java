package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.SwipeScreen;
import com.automation.mobile.utils.others.TestUtil;
import com.automation.mobile.utils.tests.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwipeCardsTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SwipeCardsTest.class);

    @Test
    public void testOne() {
        // CONDICION PREVIA: El usuario debe estar en la sección Swipe.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        HomeScreen mainScreen = returnHomeScreen();

        SwipeScreen swipeScreen = mainScreen.openSwipeScreen();
        // Verificar que esta en la seccion swipe
        Assert.assertTrue(swipeScreen.verifyBeOnSwipeScreen());


        // Deslizar el dedo hacia la derecha sobre las tarjetas
        Point initPoint = new Point(760, 1400);
        Point endPoint = new Point(160, 1400);
        Duration duration = Duration.ofSeconds(1);


        // Verificar que el anterior Cart sea diferente a las otras dos
        // comprobar que la antigua esta oculta
        // Deslizar el dedo hacia la derecha hasta la ultima tarjeta de forma que
        // compruebe que es la unica visible en la pantalla cuando no hay mas
        TestUtil.swipe(initPoint, endPoint, duration, driver);
        TestUtil.swipe(initPoint, endPoint, duration, driver);
        TestUtil.swipe(initPoint, endPoint, duration, driver);
        TestUtil.swipe(initPoint, endPoint, duration, driver);
        TestUtil.swipe(initPoint, endPoint, duration, driver);
        //Assert.assertTrue(swipeScreen.verifyIsTheLastCard());

        // Deslizar el dedo hacia abajo
        boolean youFoundMeIsDisplayed = false;
        while(!youFoundMeIsDisplayed){
            TestUtil.scrollDown(driver);
            if(swipeScreen.youFoundMeTextIsDisplayed()){
                youFoundMeIsDisplayed = swipeScreen.youFoundMeTextIsDisplayed();
            }
        }
        // Perform the scroll action
        //TestUtil.scrollUntilElementVisible(driver, new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"You found me!!!\")"));

        swipeScreen.waitSomeSeconds(3);

        // Hacer scroll verticalmente hasta encontrar «¡¡¡Me has encontrado!!!» y compruebe el texto


    }





}
