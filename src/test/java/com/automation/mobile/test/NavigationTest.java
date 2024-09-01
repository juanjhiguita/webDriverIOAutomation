package com.automation.mobile.test;

import com.automation.mobile.screens.*;
import com.automation.mobile.utils.screens.BaseScreen;
import com.automation.mobile.utils.tests.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class NavigationTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(NavigationTest.class);

    @BeforeTest
    public void beforeTest(){
        // CONDICION PREVIA: EL USUARIO DEBE ESTAR EN LA PANTALLA DE INICIO
        log.info("Test Start");
        environmentSetup();
        HomeScreen homeScreen = returnHomeScreen();
        homeScreen.waitSomeSeconds(5);
        homeScreen.openHomeScreen();
    }

    @Test
    public void verifyNavigation(){
        //Home
        HomeScreen homeScreen = new HomeScreen(driver);
        Assert.assertTrue(homeScreen.verifyBeOnMainScreen());
        Assert.assertTrue(homeScreen.isWebViewMenuBtnDisplayed());
        WebviewScreen webViewScreen = homeScreen.openWebViewScreen();
        // WebView
        Assert.assertTrue(webViewScreen.verifyBeOnWebViewScreen());
        Assert.assertTrue(webViewScreen.isLoginMenuBtnVisibleAndClickeable());
        LoginScreen loginScreen = webViewScreen.openLoginScreen();
        // Login
        Assert.assertTrue(loginScreen.verifyBeOnLoginScreen());
        Assert.assertTrue(loginScreen.isFormsMenuBtnVisibleAndClickeable());
        FormsScreen formsScreen = loginScreen.openFormsScreen();
        // Forms
        Assert.assertTrue(formsScreen.verifyBeOnFormsScreen());
        Assert.assertTrue(formsScreen.isSwipeMenuBtnVisibleAndClickeable());
        SwipeScreen swipeScreen = formsScreen.openSwipeScreen();
        // Swipe
        Assert.assertTrue(swipeScreen.verifyBeOnSwipeScreen());
        Assert.assertTrue(swipeScreen.isDragMenuBtnVisibleAndClickeable());
        DragScreen dragScreen = swipeScreen.openDragScreen();
        // Drag
        Assert.assertTrue(dragScreen.verifyBeOnDragScreen());
        Assert.assertTrue(dragScreen.isHomeMenuBtnVisibleAndClickeable());
        dragScreen.openHomeScreen();
        //Home
        homeScreen = new HomeScreen(driver);
        Assert.assertTrue(homeScreen.verifyBeOnMainScreen());
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        log.info("TERMINADO");
    }
}
