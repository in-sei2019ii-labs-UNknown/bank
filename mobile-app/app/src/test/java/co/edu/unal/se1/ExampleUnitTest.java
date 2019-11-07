package co.edu.unal.se1;

import org.junit.Test;

import static org.junit.Assert.*;

import co.edu.unal.se1.businessLogic.controller.UserController;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class ExampleUnitTest {
    UserController user = new UserController();

    //Pruebas de unidad local para el metodo transactionValidation

    @Test
    public void transactionValidation_isCorrect1() {
        assertEquals(true, user.transactionValidation(1,2,3,4)); //Esta debe pasar
    }

    @Test
    public void transactionValidation_isCorrect2() {
        assertEquals(true, user.transactionValidation(2,1,3,3)); //Esta debe fallar
    }

    //Pruebas de unidad local para el metodo printNewBalance

    @Test
    public void printNewBalance_isCorrect1(){
        assertEquals("Target User - ID: 12, Name: Manuel, Balance: 500.0", user.printNewBalance(12,"Manuel",500)); //Esta debe pasar
    }

    @Test
    public void printNewBalance_isCorrect2(){
        assertEquals("Target User - ID: 256, Name: Nicolas, Balance: 500.0", user.printNewBalance(12,"Manuel",600)); //Esta debe fallar
    }
}