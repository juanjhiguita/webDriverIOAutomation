package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.SwipeScreen;
import com.automation.mobile.utils.others.TestUtil;
import com.automation.mobile.utils.tests.BaseTest;
import org.openqa.selenium.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwipeCardsTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SwipeCardsTest.class);
    private SwipeScreen swipeScreen = new SwipeScreen(driver);
    @BeforeTest
    public void beforeTest() {
        // PREVIOUS CONDITION: The user is in the login section
        log.info("Test Start");
        environmentSetup();
    }

    @Test
    public void swipeCardsTest() {
        HomeScreen homeScreen = returnHomeScreen();
        swipeScreen = homeScreen.openSwipeScreen();
        Assert.assertTrue(swipeScreen.verifyBeOnSwipeScreen());
        Point initPoint = new Point(760, 1400);
        Point endPoint = new Point(160, 1400);
        Duration duration = Duration.ofSeconds(1);
        TestUtil.swipe(initPoint, endPoint, duration, driver);
        // Swipe to the last cart
        swipeScreen.swipeToTheLastCard(initPoint,endPoint,duration);
        // Check if is the last cart
        Assert.assertTrue(swipeScreen.isTheLast());
        // Scroll down until check that youFoundMeText is displayed
        Assert.assertTrue(TestUtil.scrollDownUntilTextYouFoundMeIsDisplayed(swipeScreen, driver));

        swipeScreen.waitSomeSeconds(4);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        log.info("Test Finish");
    }





}
