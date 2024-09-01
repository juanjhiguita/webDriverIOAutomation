package com.automation.mobile.test;

import com.automation.mobile.screens.*;
import com.automation.mobile.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void testOne(){
        // CONDICION PREVIA: EL USUARIO DEBE ESTAR EN LA PANTALLA DE INICIO

        HomeScreen homeScreen = returnMainScreen();
        // Asserts para corroborar que se esta en la main screen
        Assert.assertTrue(homeScreen.verifyBeOnMainScreen());
        // Luego, verificar que el MENU "WebView" es visible y clickeable, tambien mas propiedades
        Assert.assertTrue(homeScreen.isWebViewMenuBtnDisplayed());
        // Se sigue con el flujo
        WebViewScreen webViewScreen = homeScreen.openWebViewScreen();

        // Assert para corroborar que se esta en la pagina de WebView
        Assert.assertTrue(webViewScreen.verifyBeOnWebViewScreen());
        // Luego verificar que el MENU "Login" sea visible, clickeable y tambien mas propiedes
        Assert.assertTrue(webViewScreen.isLoginMenuBtnClickeable());
        // Se sigue con el flujo
        LoginScreen loginScreen = webViewScreen.openLoginScreen();

        // Assert para corroborar que se esta en la pagina de Login
        Assert.assertTrue(loginScreen.verifyBeOnLoginScreen());
        // Luego verificar que el MENU "Forms" sea visible, clickeable y tambien mas propiedes
        Assert.assertTrue(loginScreen.isFormsMenuBtnClickable());
        // Se sigue con el flujo
        FormsScreen formsScreen = loginScreen.openFormsScreen();

        // Assert para corroborar que se esta en la pagina de Forms
        Assert.assertTrue(formsScreen.verifyBeOnFormsScreen());
        // Luego verificar que el MENU "Swipe" sea visible, clickeable y tambien mas propiedes
        Assert.assertTrue(formsScreen.isSwipeMenuBtnClickeable());
        // Se sigue con el flujo
        SwipeScreen swipeScreen = formsScreen.openSwipeScreen();

        // Assert para corroborar que se esta en la pagina de Swipe
        Assert.assertTrue(swipeScreen.verifyBeOnSwipeScreen());
        // Luego verificar que el MENU "Drag" sea visible, clickeable y tambien mas propiedes
        Assert.assertTrue(swipeScreen.isDragMenuBtnClickable());
        // Sigue con el flujo
        DragScreen dragScreen = swipeScreen.openDragScreen();

        // Assert para corroborar que se esta en la pagina de drag
        Assert.assertTrue(dragScreen.verifyBeOnDragScreen());
    }
}
