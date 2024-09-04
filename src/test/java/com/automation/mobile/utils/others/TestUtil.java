package com.automation.mobile.utils.others;

import com.automation.mobile.screens.SwipeScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.*;

public class TestUtil {
    private static final String EMAIL_DOMAIN = "@example.com";
    private static final int EMAIL_LENGTH = 10;
    private static final int PASSWORD_LENGTH = 12;
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = LOWER.toUpperCase(Locale.ROOT);
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:',.<>?/";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomEmail() {
        return generateRandomString(EMAIL_LENGTH) + EMAIL_DOMAIN;
    }

    public static String generateRandomPassword() {
        return generateRandomString(PASSWORD_LENGTH, LOWER + UPPER + DIGITS + SPECIAL);
    }

    private static String generateRandomString(int length) {
        return generateRandomString(length, LOWER + UPPER + DIGITS);
    }

    private static String generateRandomString(int length, String characterSet) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (characterSet.isEmpty()) {
            throw new IllegalArgumentException("Character set must not be empty");
        }

        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(characterSet.length());
            result.append(characterSet.charAt(index));
        }
        return result.toString();
    }

    public static void swipe(Point start, Point end, Duration duration, AndroidDriver driver) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 1);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(0));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(0));

        driver.perform(Collections.singletonList(swipe));
    }

    public static void scrollDown(AndroidDriver driver) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);

        scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 0, 1000))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 0, 0))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(scroll);

        driver.perform(sequences);
    }

    public static boolean scrollDownUntilTextYouFoundMeIsDisplayed(SwipeScreen swipeScreen, AndroidDriver driver){
        boolean youFoundMeIsDisplayed = false;
        while(!youFoundMeIsDisplayed){
            TestUtil.scrollDown(driver);
            if(swipeScreen.youFoundMeTextIsDisplayed()){
                youFoundMeIsDisplayed = swipeScreen.youFoundMeTextIsDisplayed();
            }
        }
        return youFoundMeIsDisplayed;
    }
}
