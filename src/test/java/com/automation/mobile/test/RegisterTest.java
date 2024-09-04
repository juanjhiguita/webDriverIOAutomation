package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.LoginScreen;
import com.automation.mobile.utils.others.TestUtil;
import com.automation.mobile.utils.tests.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(RegisterTest.class);
    private LoginScreen loginScreen = new LoginScreen(driver);

    @BeforeTest
    public void beforeTest() {
        // PREVIOUS CONDITION: The user is in the login section
        log.info("Test Start");
        environmentSetup();
        HomeScreen homeScreen = returnHomeScreen();
        loginScreen = homeScreen.openLoginScreen();
        Assert.assertTrue(loginScreen.verifyBeOnLoginScreen());
    }

    @Test
    public void verifyRegisterTest(){
        Assert.assertTrue(loginScreen.isSignUpClickable());
        loginScreen.openSignUpFormulary();
        Assert.assertTrue(loginScreen.isPasswordFieldVisible());
        // Generate a random credentials
        String email = TestUtil.generateRandomEmail();;
        String password = TestUtil.generateRandomPassword();
        // Fill the sign up formulary
        loginScreen.fillSignUpFormulary(email, password, password);
        Assert.assertTrue(loginScreen.isSignUpClickable());
        loginScreen.clickSignUpBtn();
        // Alert
        Assert.assertTrue(loginScreen.isSignUpAlertEqualsExpected());
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        log.info("Test Finish");
    }
}
