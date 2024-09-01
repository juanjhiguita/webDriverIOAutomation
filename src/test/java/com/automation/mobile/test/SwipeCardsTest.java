package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.SwipeScreen;
import com.automation.mobile.utils.tests.BaseTest;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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
    public void testOne(){
        // CONDICION PREVIA: El usuario debe estar en la sección Swipe.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        HomeScreen mainScreen = returnMainScreen();

        SwipeScreen swipeScreen = mainScreen.openSwipeScreen();
        // Verificar que esta en la seccion swipe
        Assert.assertTrue(swipeScreen.verifyBeOnSwipeScreen());

        // Deslizar el dedo hacia la derecha sobre las tarjetas
        Point initPoint = new Point(760,1690);
        Point endPoint = new Point(160,1690);
        Duration duration = Duration.ofSeconds(1,5);
        swipeScreen.waitSomeSeconds(5);

        swipeScreen.swipe(initPoint,endPoint,duration);
        // Verificar que el anterior Cart sea diferente a las otras dos
        // comprobar que la antigua esta oculta
        // Deslizar el dedo hacia la derecha hasta la ultima tarjeta de forma que
        // compruebe que es la unica visible en la pantalla cuando no hay mas
        swipeScreen.swipe(initPoint,endPoint,duration);
        swipeScreen.swipe(initPoint,endPoint,duration);
        swipeScreen.swipe(initPoint,endPoint,duration);
        swipeScreen.swipe(initPoint,endPoint,duration);

        // Hacer scroll verticalmente hasta encontrar «¡¡¡Me has encontrado!!!» y compruebe el texto


    }




}
