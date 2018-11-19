import Exceptions.UserAlreadyExists;
import org.junit.jupiter.api.*;


public class TestAddCredit {

    private BikeRentalSystem bRental;
    private static final int rentalFee=25;

    /**
     * Iniciar o "sistema"(bRental) com apenas um utilizador e com o credito=0;
     */
    @BeforeEach
    public void testAddCredit() {
        bRental = new BikeRentalSystem(rentalFee);
        try {
            bRental.registerUser(2, "Teste", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }



    }
    /** TestCase 1
     * Utilizador id=2, credito =0 e vai adicionar +2;
     */
    //@Test
    public void testAddCredit1(){
        bRental.addCredit(2,2);
        Assertions.assertEquals(2,bRental.getUsers().get(0).getCredit(),"Credit deve ser igual a 2");
    }
    /** TestCase 2
     * Utilizador id=2 , credito =0 e vai adicionar +maxInt;
     */

    //@Test
    public void testAddCredit2() {
        bRental.addCredit(2, Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MAX_VALUE,bRental.getUsers().get(0).getCredit(),"Amount deve ser igual a maxInt");
    }

    /* TestCase 3
     * Utilizador id=2, credito =0 e vai adicionar 1;
     */

    //  @Test
    public void testAddCredit3(){
        bRental.addCredit(2,1);
        Assertions.assertEquals(1,bRental.getUsers().get(0).getCredit(),"Amount deve ser igual a 1");
    }

    /* TestCase 4
     * Utilizador id=2, credito =0 e nao vai adicionar credito;
     */


    //@Test
    public void testAddCredit4(){
        bRental.addCredit(2,0);
        Assertions.assertEquals(0,bRental.getUsers().get(0).getCredit(),"Amount=0, deve retornar 0");
    }

    /** TestCase 5
     * Utilizador id=1 logo nao existe nao podera ter credito se usar o verifyCredit ;
     */

    //@Test
    public void testAddCredit5(){
        bRental.addCredit(1,2);
        Assertions.assertFalse(bRental.verifyCredit(1));
    }

    /** TestCase 6
     * Utilizador id=2 mas com credito= -100 e adiciona metade do debito;
     */

    //@Test
    public void testAddCredit6(){

        bRental.getUsers().get(0).setCredit(-100);
        bRental.addCredit(2,50);

        Assertions.assertEquals(-50,bRental.getUsers().get(0).getCredit());
    }

    /** TestCase 7
     * Utilizador id=2 mas com credito= -100 o que debito;
     */


    // @Test
    public void testAddCredit7(){

        bRental.getUsers().get(0).setCredit(-100);
        bRental.addCredit(2,100);

        Assertions.assertEquals(0,bRental.getUsers().get(0).getCredit());
    }

    /** TestCase 8
     * Utilizador id=2 mas com credito= -100 e adiciona o que debito+1;
     */

    @Test
    public void testAddCredit8(){

        bRental.getUsers().get(0).setCredit(-100);
        bRental.addCredit(2,101);

        Assertions.assertEquals(1,bRental.getUsers().get(0).getCredit());
    }

    /**
     * Utilizador id=2 com credito=10 e tenta adicionar um credito com um valor negativo
     * deve nao adicionar
     */
    @Test
    public void testAddCredit9(){

        bRental.addCredit(2, 10);
        bRental.addCredit(2,-20);

        Assertions.assertEquals(10 ,bRental.getUsers().get(0).getCredit());
    }

}


