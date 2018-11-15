import Exceptions.UserAlreadyExists;
import Exceptions.UserDoesNotExists;

public class BikeSharingMain {
    public static void main(String[] args) {
        BikeRentalSystem bRental = new BikeRentalSystem(25);

    try {
        bRental.registerUser(1,"Rui",1);
    } catch (UserAlreadyExists userAlreadyExists) {
        userAlreadyExists.printStackTrace();
    }
        /**
         * Adicionar crédito
         */
        bRental.addCredit(1, 50);
        /**
         * Adicionar bicileta
         */
        bRental.addBicycle(-1, -1,-1);
        /**
         * Alugar bicicleta
         */
        try {
            bRental.getBicycle(-1,1,-1);
        } catch (UserDoesNotExists userDoesNotExists) {
            userDoesNotExists.printStackTrace();
        }

        /**
         * calcular Fee?
         */
        System.out.println(bRental.bicycleRentalFee(1, 0, 4, 1));

        /**
         * Devolver bicicleta
         */
        bRental.returnBicycle(-1,1,0);

        /**
         * Prints
         */
        System.out.println(bRental.getDeposits());

        System.out.println(bRental.getUsers());

        System.out.println("Rental Fee: " + bRental.getRentalFee());


    }
}
