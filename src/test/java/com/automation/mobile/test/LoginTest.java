package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.LoginScreen;
import com.automation.mobile.utils.tests.BaseTest;
import org.openqa.selenium.bidi.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(RegisterTest.class);
    private LoginScreen loginScreen = new LoginScreen(driver);

    @BeforeMethod
    public void beforeTest() {
        // PREVIOUS CONDITION: The user is in the login section and should have a user created previously
        log.info("Test Start");
        environmentSetup();
        HomeScreen homeScreen = returnHomeScreen();
        loginScreen = homeScreen.openLoginScreen();
        Assert.assertTrue(loginScreen.verifyBeOnLoginScreen());
    }

    @Test
    public void oneTest(){
        // Set the credentials generated in the register test
        String email = LoginScreen.emailRegistered;
        String password = LoginScreen.passwordRegistered;
        loginScreen.fillLoginFormulary(email, password);
        Assert.assertTrue(loginScreen.isLoginBtnVisible());
        loginScreen.clickLoginBtn();
        Assert.assertTrue(loginScreen.isLoginAlertEqualsExpected());
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        log.info("Test Finish");
    }
}
