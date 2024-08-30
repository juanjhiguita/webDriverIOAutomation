package com.automation.mobile.test;

import com.automation.mobile.screens.LoginScreen;
import com.automation.mobile.screens.MainScreen;
import com.automation.mobile.utils.tests.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(RegisterTest.class);

    @Test
    public void testOne(){
        // CONDICION PREVIA: el usuario debe estar en la sección Inicio de sesión
        MainScreen mainScreen = returnMainScreen();

        LoginScreen loginScreen = mainScreen.openLoginScreen();
        // Assert para corroborar que se esta en la pagina de Login
        Assert.assertTrue(loginScreen.verifyBeOnLoginScreen());
        // Luego, verificar que el MENU "Sign up" es visible y clickeable
        Assert.assertTrue(loginScreen.isSignUpClickable());

        loginScreen.openSignUpFormulary();
        // Assert para verificar que aparecio el nuevo campo
        Assert.assertTrue(loginScreen.isPasswordFieldVisible());

        // Rellenar el formulario (Tenga en cuenta que la prueba debe poder ejecutarse varias veces,
        // por lo que puede generarse un correo electrónico aleatorio cada vez o debe realizarse
        // una accion despues de la prueba para eliminar la cuenta creada)
        String email = "prueba@gmail.com";
        String password = "Prueba198.";
        String confirmPassowrd = "Prueba198.";

        loginScreen.fillSignUpFormulary(email, password, confirmPassowrd);

        // Validacion que el boton de "Sign up" sea clickeable
        Assert.assertTrue(loginScreen.isSignUpClickable());
        // Hacer click en el boton de "Sign up"
        loginScreen.clickSignUpBtn();
        Assert.assertTrue(loginScreen.isSignUpAlertEqualsExpected());
        // Assert para comprobar que el proceso de registro se ha completado con exito
    }
}
