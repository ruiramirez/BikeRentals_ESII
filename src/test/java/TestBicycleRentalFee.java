import Exceptions.UserAlreadyExists;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;

public class TestBicycleRentalFee {

    private BikeRentalSystem bRental;
    private static final int rentalFee = 25;

    /**
     * Este método vai assumir que existe já um User com IDUser = 2 e com um rentalProgram = 1
     *
     */
    @BeforeEach
    public void criarVidaSoftware(){

        bRental = new BikeRentalSystem(rentalFee);
        try {
            bRental.registerUser(2, "Teste", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }

        bRental.addLock(1,1);
        bRental.addBicycle(1,1,1);

    }

    /**
     * TestCase#1
     * Verifica se com o rentalProgram igual 0 (LB) se retorna 0
     */
    @Test
    public void testBicycleRentalFee1(){
        Assertions.assertEquals(0, bRental.bicycleRentalFee(0,1,2,2), "Deve retornar 0.");
    }

    /**
     * TestCase#2
     * Verifica se com o rentalProgram igual ao MAX_INT (UB) se retorna o
     */
    @Test
    public void testBicycleRentalFee2(){
        Assertions.assertEquals(0, bRental.bicycleRentalFee(Integer.MAX_VALUE,1,2,2), "Deve retornar 0.");

    }

    /**
     * TestCase#3
     * Verifica se o startTime > endtime e ou não executado
     */
    @Ignore
    public void testBicycleRentalFee3(){
        int endTime = 1, startime = 2, calc = (endTime - startime) * rentalFee;

        //Assertions.assertTrue(bRental.bicycleRentalFee(1, startime, endTime, 3) < 0);
        Assertions.assertNotEquals(calc, bRental.bicycleRentalFee(1, startime, endTime, 3));
    }

    /**
     * TestCase#4
     * Verificar se o programa executa corretamente com os dados inseridos
     * rentalProgram = 1
     * startTime = 1
     * endTime = 2
     * nRentals = 2
     */
    @Test
    public void testBicycleRentalFee4(){
        int endTime = 2, startTime = 1, nRentals = 2, calc = (endTime - startTime) * rentalFee;
        Assertions.assertEquals(calc, bRental.bicycleRentalFee(1, startTime, endTime, nRentals));
    }

    /**
     * TestCase#5
     * Verificar se o programa retorna 0, visto que o resto da divisão de nRentals por 10 é igual a 0 e rentalProgram = 2
     * rentalProgram = 2
     * startTime = 1
     * endTime = 2
     * nRentals = 20
     */
    @Test
    public void testBicycleRentalFee5(){
        int endTime = 2, startTime = 1, nRentals = 20;
        Assertions.assertEquals(0, bRental.bicycleRentalFee(2, startTime, endTime, nRentals));

    }

    /**
     * TestCase#6
     * Verifica se o método retorna -250, visto que o o rentalProgram é igual a 2 e o resto da divisão por 10 é diferente de 0 e o endTime - startTime <= 10
     * rentalProgram = 2
     * startTime = 15
     * endTime = 5
     * nRentals = 3
     */
    @Test
    public void testBicycleRentalFee6(){
        int endTime = 5, startTime = 15, nRentals = 3, calc = rentalFee * (endTime - startTime);
        Assertions.assertEquals(calc, bRental.bicycleRentalFee(2, startTime, endTime, nRentals));
    }

    /**
     * TestCase#7
     * Verifica se o metodo retorna -275, visto que o rentalProgram é igual a 2, o resto da divisao por 10 e diferente de 0 e o endTime - startTime > 10
     * rentalProgram = 2
     * startTime = 16
     * endTime = 5
     * nRentas = 3
     */
    @Test
    public void testBicycleRentalFee7(){
        int endTime = 5, startTime = 16, nRentals = 3, calc = 10*rentalFee + ((endTime - startTime)-10)* rentalFee;
        Assertions.assertEquals(calc, bRental.bicycleRentalFee(2, startTime, endTime, nRentals));
    }
    /**
     * TestCase#8
     * Verifica se o programa é executado dado que nRentals = -1 (BLB)
     */
    @Test
    public void testBicycleRentalFee8(){
        System.out.println(bRental.bicycleRentalFee(2, 5, 10, -1));
        Assertions.assertNotEquals(-1, bRental.bicycleRentalFee(2, 5, 10, -1));

    }
    /**
     * TestCase#9
     *
     */
    @Test
    public void testBicycleRentalFee9(){

    }
    /**
     * TestCase#10
     *
     */
    @Test
    public void testBicycleRentalFee10(){

    }
}
