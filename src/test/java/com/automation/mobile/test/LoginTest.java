package com.automation.mobile.test;

import com.automation.mobile.screens.HomeScreen;
import com.automation.mobile.screens.LoginScreen;
import com.automation.mobile.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void oneTest(){
        // CONDICION PREVIA: El usuario debe estar en la sección de Login y tener un usuario previamente creado.

        HomeScreen mainScreen = returnMainScreen();

        LoginScreen loginScreen = mainScreen.openLoginScreen();
        // Assert para corroborar que se esta en la pagina de Login
        Assert.assertTrue(loginScreen.verifyBeOnLoginScreen());
        // Luego, verificar que el MENU "Login" es visible y clickeable, tambien mas propiedades
        // Rellenar el formulario con la informacion del usuario previamente creado
        String email = "prueba@gmail.com";
        String password = "Prueba198.";

        loginScreen.fillLoginFormulary(email, password);
        // Darle click al boton "login"
        Assert.assertTrue(loginScreen.isLoginBtnVisible());
        loginScreen.clickLoginBtn();
        // Assert para comprobar el Alert
        Assert.assertTrue(loginScreen.isLoginAlertEqualsExpected());
    }
}
