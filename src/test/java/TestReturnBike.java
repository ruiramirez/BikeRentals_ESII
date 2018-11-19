import Exceptions.UserAlreadyExists;
import Exceptions.UserDoesNotExists;
import org.junit.jupiter.api.*;

public class TestReturnBike {

    private BikeRentalSystem bRental;
    private static final int rentalFee=25;
    /**
     * Iniciar o "sistema"(bRental) com apenas um utilizador e com o credito=0;
     */
    @BeforeEach
    public void testReturnBike() {
        bRental = new BikeRentalSystem(rentalFee);
        try {
            bRental.registerUser(2, "Teste", 1);


        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }


    }

    /** #TestCase1
     *  Tenta retornar uma bicicleta para um deposito que nao existe
     *  Deve retornar -1;
     */

    //@Test
    public void returnBicycle1(){
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2,1);

        try {
            bRental.getBicycle(1,2,0);
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }

        Assertions.assertEquals(-1,bRental.returnBicycle(0,2,1));
    }


    /** #TestCase2
     *  Tenta retornar uma bicicleta mas nao usa um id de user existente
     *  Deve retornar -1;
     */

   //@Test
    public void returnBicycle2(){
        bRental.addBicycle(1, 1, 5);




        Assertions.assertEquals(-1,bRental.returnBicycle(0,1,1));
    }

    /** #TestCase3
     *  Tenta retornar uma bicicleta mas nao tem uma bicicleta na sua posse
     *  Deve retornar -1;
     */

    //@Test
    public void returnBicycle3(){
        bRental.addBicycle(1, 1, 5);
        Assertions.assertEquals(-1,bRental.returnBicycle(1,2,1));
    }


    /** #TestCase4
     *  Tenta retornar uma bicicleta mas nao tem lugar disponivel no deposito
     *  Deve retornar -1;
     */

   // @Test
    public void returnBicycle4(){
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2,1);

        try {
            bRental.getBicycle(1,2,1);
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }

        bRental.addBicycle(1,1,6);




        Assertions.assertEquals(-1,bRental.returnBicycle(1,2,2));
    }




    //Testar os limites do endTime

    /** #TestCase5
     *  Tenta retornar uma bicicleta com um endtime com valor invalido
     *  Nao deve devolver a bicicleta
     */

    // @Test
    public void returnBicycle5(){
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2,25);

        try {
            bRental.getBicycle(1,2,0);
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
        Assertions.assertNotEquals(1,bRental.returnBicycle(1,2,-1));

    }

    /** #TestCase6
     *  Tenta retornar uma bicicleta com o endTime=0;
     *  Deve retornar 1 ou seja devolveu a bicicleta ao lock 1;
     */

    //@Test
    public void returnBicycle6(){
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2,25);

        try {
            bRental.getBicycle(1,2,0);
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
        Assertions.assertEquals(1,bRental.returnBicycle(1,2,0));

    }

    /** #TestCase6
     *  Tenta retornar uma bicicleta com o endTime=0;
     *  Deve retornar 1 ou seja devolveu a bicicleta ao lock 1;
     */

    @Test
    public void returnBicycle7(){
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2,25);

        try {
            bRental.getBicycle(1,2,0);
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
        Assertions.assertEquals(1,bRental.returnBicycle(1,2,1));

    }

   // @Test
    public void returnBicycle8(){
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2,25);

        try {
            bRental.getBicycle(1,2,0);
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
        Assertions.assertEquals(1,bRental.returnBicycle(1,2,Integer.MAX_VALUE));

    }






}
