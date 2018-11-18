import Exceptions.UserAlreadyExists;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;

public class TestRegisterUser {

    private BikeRentalSystem bRental;
    private static final int rentalFee = 25;

    /**
     * Este método vai assumir que já existe um User com os seguintes argumentos (IDUser: 2, name: "Teste", rentalProgram: 1),
     * e a criação de um BikeRentalSystem com um rentalFee = 25 e irá executar antes de executar qualquer outro método de teste.
     */

    @BeforeEach
    public void criarVidaSoftware(){
        bRental = new BikeRentalSystem(rentalFee);
        try {
            bRental.registerUser(2, "Teste", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
    }

    /**
     * TestCase#1
     * Testa se o método registerUser adiciona um User com id negativo (BLB)
     */
    @Ignore
    public void testRegisterUser1(){
        int oldSize = bRental.getUsers().size();
        try {
            bRental.registerUser(-1, "ola", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();

        Assertions.assertEquals(oldSize, size, "É esperado que não adicione um User com IDUser negativo.");
    }

    /**
     * TestCase#2
     * Testa se o método registerUser adiciona um User com id igual a 0 (LB)
     */
    @Test
    public void testRegisterUser2(){

        try {
            bRental.registerUser(0, "testCase", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();

        Assertions.assertEquals(2, size, "É esperado que adicione um User com IDUser maior ou igual a 0.");
    }


    /**
     * TestCase#3
     * Testa se o método registerUser adiciona um User com id igual a 1 (ALB)
     */

    @Test
    public void testRegisterUser3(){

        try {
            bRental.registerUser(1, "testCase", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();

        Assertions.assertEquals(2, size, "É esperado que adicione um User com IDUser maior ou igual a 0.");
    }

    /**
     * TestCase#4
     * Testa se o método registerUser adiciona um User com id igual a MAX_INT(UB)
     */

    @Test
    public void testRegisterUser4(){

        try {
            bRental.registerUser(Integer.MAX_VALUE, "testCase", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();

        Assertions.assertEquals(2, size, "\"É esperado que adicione um User com IDUser maior ou igual a 0 e menor ou igual que MAX_INT");
    }

    /**
     * TestCase#5
     * Testa se o método registerUser lança exceção quando se tenta adicionar um User com IDUser existente.
     */

    @Test
    public void testRegisterUser5(){
        Assertions.assertThrows(UserAlreadyExists.class, () -> bRental.registerUser(2, "TesteCase", 1), "Deve lançar exceção");
    }

    /**
     * TestCase#6
     * Testa se o método registerUser cria um User com um name(String) com 2 carateres(LB) .
     */

    @Test
    public void testRegisterUser6(){

        try {
            bRental.registerUser(Integer.MAX_VALUE, "tc", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();

        Assertions.assertEquals(2, size, "É esperado que aceite um user com um name de 2 carateres.");
    }

    /**
     * TestCase#7
     * Testa se o método registerUser cria um User com um name(String) com 3 carateres(ALB) .
     */

    @Test
    public void testRegisterUser7(){

        try {
            bRental.registerUser(Integer.MAX_VALUE, "tca", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();

        Assertions.assertEquals(2, size, "É esperado que aceite um user com um name de 3 carateres.");
    }

    /**
     * TestCase#8
     * Testa se o método registerUser cria um User com um name(String) com 100 carateres(UB) .
     */

    @Test
    public void testRegisterUser8(){

        String nome = "Rui Pedro Mario Ferreira Castro Miguel Jorge Mendes Leite Daniel Miguel Pacheco Silva Testando Eng S";


        try {
            bRental.registerUser(Integer.MAX_VALUE, nome, 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();

        Assertions.assertEquals(2, size, "É esperado que aceite um user com um name de 100 carateres.");
    }

    /**
     * TestCase#9
     * Testa se o método registerUser cria um User com um name(String) com 101 carateres(AUB) .
     */

    @Ignore
    public void testRegisterUser9(){

        String nome = "Rui Pedro Mario Ferreira Castro Miguel Jorge Mendes Leite Daniel Miguel Pacheco Silva Testando Eng SW";
        System.out.println(nome.length());

        try {
            bRental.registerUser(Integer.MAX_VALUE, nome, 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();

        Assertions.assertEquals(1, size, "É esperado que não aceite um user com um name de 101 carateres.");

    }

    /**
     * TestCase#10
     * Testa se o método registerUser cria um User com um name(String) com 1 carateres(BLB) .
     */

    @Ignore
    public void testRegisterUser10(){

        String nome = "R";

        try {
            bRental.registerUser(Integer.MAX_VALUE, nome, 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();

        Assertions.assertEquals(1, size, "É esperado que não aceite um user com um name de 1 caratere.");

    }

    /**
     * TestCase#11
     * Testa se o método registerUser cria um User com um name(String) NULL.
     */

    @Ignore
    public void testRegisterUser11(){

        String nome = null;

        try {
            bRental.registerUser(Integer.MAX_VALUE, nome, 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();
        Assertions.assertEquals(1, size, "É esperado que não aceite um user com um name NULL.");
    }

    /**
     * TestCase#12
     * Testa se o método registerUser cria um User com um rentalProgram igual a 0 (BLB).
     */
    @Ignore
    public void testRegisterUser12(){

        try {
            bRental.registerUser(Integer.MAX_VALUE, "testCase", 0);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();
        Assertions.assertEquals(1, size, "E esperado que nao aceite um user com um rentalProgram igual a 0.");
    }

    /**
     * TestCase#13
     * Testa se o método registerUser cria um User com um rentalProgram igual a 1 (LB, BUB).
     */
    @Test
    public void testRegisterUser13(){

        try {
            bRental.registerUser(Integer.MAX_VALUE, "testCase", 1);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();
        Assertions.assertEquals(2, size, "E esperado que aceite um user com um rentalProgram igual a 1.");
    }

    /**
     * TestCase#14
     * Testa se o método registerUser cria um User com um rentalProgram igual a 2 (UB, ALB).
     */
    @Test
    public void testRegisterUser14(){

        try {
            bRental.registerUser(Integer.MAX_VALUE, "testCase", 2);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();
        Assertions.assertEquals(2, size, "E esperado que aceite um user com um rentalProgram igual a 2.");
    }

    /**
     * TestCase#15
     * Testa se o método registerUser cria um User com um rentalProgram igual a 3 (AUB).
     */
    @Ignore
    public void testRegisterUser15(){

        try {
            bRental.registerUser(Integer.MAX_VALUE, "testCase", 3);
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        }
        int size = bRental.getUsers().size();
        Assertions.assertEquals(1, size, "E esperado que nao aceite um user com um rentalProgram igual a 3.");
    }


}
