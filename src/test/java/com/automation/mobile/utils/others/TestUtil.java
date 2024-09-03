package com.automation.mobile.utils.others;

import com.sun.org.apache.xpath.internal.operations.And;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.*;

import static com.automation.mobile.utils.tests.BaseTest.driver;

public class TestUtil {
    private static final String EMAIL_DOMAIN = "@example.com";
    private static final int EMAIL_LENGTH = 10;
    private static final int PASSWORD_LENGTH = 12;

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = LOWER.toUpperCase(Locale.ROOT);
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

    static double SCROLL_RATIO = 0.5;
    static Duration SCROLL_DUR = Duration.ofMillis(500);

    private static final String ALL_CHARACTERS = LOWER + UPPER + DIGITS + SPECIAL;
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

    public static void scrollToElement(WebElement element, AndroidDriver driver) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);

        // Obtener la posición del elemento
        int x = element.getLocation().x;
        int y = element.getLocation().y;

        scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(scroll);

        driver.perform(sequences);
    }

    public static void scrollUntilElementVisible(AndroidDriver driver, By elementLocator) {
        boolean isElementVisible = false;

        // Realiza el scroll solo si el elemento no es visible
        while (!isElementVisible) {
            // Realiza el scroll hacia abajo
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"))));


            // Verifica si el elemento es visible después del scroll
            isElementVisible = isElementVisible(driver, elementLocator);
        }
    }


    private static boolean isElementVisible(AndroidDriver driver, By elementLocator) {
        try {
            // Intenta encontrar el elemento en la pantalla
            driver.findElement(elementLocator);
            // Devuelve verdadero si el elemento está visible
            return true;
        } catch (NoSuchElementException e) {
            // Si el elemento no está presente o no es visible, captura la excepción y devuelve falso
            return false;
        }
    }



    public static boolean isEndOfPage(String pageSource, AndroidDriver driver) {
        return pageSource.equals(driver.getPageSource());
    }


}
