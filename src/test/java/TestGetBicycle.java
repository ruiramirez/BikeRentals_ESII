import Exceptions.UserAlreadyExists;
import Exceptions.UserDoesNotExists;
import org.junit.jupiter.api.*;


public class TestGetBicycle {

    private BikeRentalSystem bRental;
    private static final int rentalFee = 25;

    /**
     * Iniciar o "sistema"(bRental) com apenas um utilizador e com o credito=0;
     */
    @BeforeEach
    public void testGetBicycle() {
        bRental = new BikeRentalSystem(rentalFee);
        try {
            bRental.registerUser(2, "Teste", 1);


        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
    }

    /**
     * #TestCase1
     * Tenta alugar uma bicicleta com um startTime invalido
     * Nao devia retornar;
     */

    @Test
    public void testGetBicycle1() {
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2, 1);

        try {
            Assertions.assertNotEquals(5, bRental.getBicycle(1, 2, -1));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
    }

    /**
     * #TestCase2
     * Tenta alugar uma bicicleta com um startTime=0;
     */

    @Test
    public void testGetBicycle2() {
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2, 1);

        try {
            Assertions.assertEquals(5, bRental.getBicycle(1, 2, 0));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
    }

    /**
     * #TestCase3
     * Tenta alugar uma bicicleta com um startTime=1 e com credito para alugar a bicicleta;
     */

    @Test
    public void testGetBicycle3() {
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2, 1);

        try {
            Assertions.assertEquals(5, bRental.getBicycle(1, 2, 1));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
    }

    /**
     * #TestCase4
     * Tenta alugar uma bicicleta com um startTime=maxInt e com credito para alugar a bicicleta;
     * Nao faz sentido usar o maxInt porque depois o endTime tera de ser maxInt logo nao faz muito sentido
     */

    @Test
    public void testGetBicycle4() {
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2, 1);

        try {
            Assertions.assertEquals(5, bRental.getBicycle(1, 2, Integer.MAX_VALUE));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
    }


    /**
     * #TestCase5
     * Tenta alugar uma bicicleta com um utilizador que nao existe, nao importa o valor do startTime pois
     * terá de retornar sempre a exceçao em que este nao existe
     */

    @Test
    public void testGetBicycle5() {
        bRental.addBicycle(1, 1, 5);
        Assertions.assertThrows(UserDoesNotExists.class, () -> bRental.getBicycle(1, 1, 0));
    }

    /**
     * #TestCase6
     * Tenta alugar uma bicicleta com um utilizador que existe, mas nao existe depositio nao importa o valor do startTime pois
     * terá de retornar -1
     */

    @Test
    public void testGetBicycle6() {
        bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2, 1);

        try {
            Assertions.assertEquals(-1, bRental.getBicycle(2, 2, Integer.MAX_VALUE));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
    }

    /**
     * #TestCase7
     * Tenta alugar uma bicicleta com um utilizador que existe,  deposito existe e startime valido mas nao tem credito;
     * terá de retornar -1
     */

    @Test
    public void testGetBicycle7() {
        bRental.addBicycle(1, 1, 5);

        try {

            Assertions.assertEquals(-1, bRental.getBicycle(1, 2, Integer.MAX_VALUE));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();

        }
    }

    /**
     * #TestCase8
     * Tenta alugar uma bicicleta com um utilizador que existe,  depois existe e startime valido, tem credito mas nao existe bike disponivel
     * terá de retornar -1
     */

    @Test
    public void testGetBicycle8() {
        // bRental.addBicycle(1, 1, 5);
        bRental.addCredit(2, 1);


        try {

            Assertions.assertEquals(-1, bRental.getBicycle(1, 2, Integer.MAX_VALUE));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();

        }
    }

    /**
     * #TestCase9
     * Tenta alugar uma bicicleta com um utilizador que existe,  depois existe e startime valido, tem credito mas ja tem na sua posse uma bicicleta mas ainda ha bicicletas disponiveis
     * terá de retornar -1
     */

    @Test
    public void testGetBicycle9() {
        bRental.addBicycle(1, 1, 6);
        bRental.addBicycle(1, 2, 5);
        bRental.addCredit(2, 1);
        try {
            bRental.getBicycle(1, 2, 1);
            Assertions.assertEquals(-1, bRental.getBicycle(1, 2, Integer.MAX_VALUE));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
    }

    /**
     * #TestCase10
     * Tenta alugar uma bicicleta com um utilizador que existe,  depois existe e startime valido, tem credito mas ja tem na sua posse uma bicicleta mas nao ha bikes disponiveis
     * terá de retornar -1
     */

    @Test
    public void testGetBicycle10() {
        bRental.addBicycle(1, 1, 6);

        bRental.addCredit(2, 1);
        try {
            bRental.getBicycle(1, 2, 1);
            Assertions.assertEquals(-1, bRental.getBicycle(1, 2, Integer.MAX_VALUE));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }

    }

    /**
     * #TestCase11
     * Tenta alugar uma bicicleta com um utilizador que existe,  deposito existe e startime valido, mas tem credito negativo
     * terá de retornar -1
     */

    @Test
    public void testGetBicycle11() {
        bRental.addBicycle(1, 1, 6);

        bRental.getUsers().get(0).setCredit(-120);
        try {
            Assertions.assertEquals(-1, bRental.getBicycle(1, 2, Integer.MAX_VALUE));
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }
    }

}