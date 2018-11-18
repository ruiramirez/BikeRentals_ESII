import Exceptions.UserAlreadyExists;
import Exceptions.UserDoesNotExists;
import org.junit.jupiter.api.*;


public class TestVerifyCredit {

    private BikeRentalSystem bRental;
    private static final int rentalFee = 25;

    /**
     * Inicializaçao aos testes do método verifyCredit()
     * Instanciaçao de um BikeRentalSystem e de um User
     */
    @BeforeEach
    public void criarVidaSoftware() {
        bRental = new BikeRentalSystem(rentalFee);
        try {
            bRental.registerUser(2, "Teste", 1);

        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }


    }

    /**
     * TestCase#1
     * Verifica se com o crédito a 0 e com um User existente o método retorna falso.
     */
    @Test
    public void testVerifyCredit1() {

        Assertions.assertFalse(bRental.verifyCredit(2), "Credito=0, deve retornar false");

    }

    /**
     * TestCase#2
     * Verifica se com o crédito no limite máximo (Integer.MAX_VALUE) e com um User existente o método retorna true.
     */
    @Test
    public void testVerifyCredit2() {
        bRental.addCredit(2, Integer.MAX_VALUE);

        Assertions.assertTrue(bRental.verifyCredit(2), "Credito=MaxInt, deve retornar true");
    }

    /**
     * TestCase#3
     * Verifica se com o crédito a 1 e com um User existente o método retorna true.
     */
    @Test
    public void testVerifyCredit3() {
        bRental.addCredit(2, 1);
        Assertions.assertTrue(bRental.verifyCredit(2), "Credito=1, deve retornar true");
    }


    /**
     * TestCase#4
     * Verifica se com o crédito negativo e com um User existente o método retorna falso.
     */
    @Test
    public void testVerifyCredit4() {
        //Adiciona algum credito para alugar uma bicicleta
        bRental.addCredit(2, 25);
        //Cria uma bicicleta
        bRental.addBicycle(1, 1, 1);
        try {
            //Aluga uma bicicleta
            bRental.getBicycle(1, 2, 1);
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
        //Retorna a bicicleta mas fica com saldo negativo
        bRental.returnBicycle(1, 2, 3);
        Assertions.assertFalse(bRental.verifyCredit(2), "Credito=negativo, deve retornar false");

    }

    /**
     * TestCase#5
     * Verifica se com um User não existente o método retorna falso.
     */
    @Test
    public void testVerifyCredit5() {
        Assertions.assertFalse(bRental.verifyCredit(1), "Deve retornar false porque nao existe o utilizador");
    }


}
