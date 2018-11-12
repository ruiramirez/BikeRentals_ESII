import Exceptions.UserAlreadyExists;

public class BikeSharingMain {
    public static void main(String[] args) {
        BikeRentalSystem bRental = new BikeRentalSystem(25);

    try {
        bRental.registerUser(1,"Rui",1);
    } catch (UserAlreadyExists userAlreadyExists) {
        userAlreadyExists.printStackTrace();
    }
        bRental.addBicycle(1, 1,1);
        bRental.addCredit(1, 50);
        System.out.println(bRental.getDeposits());

        System.out.println(bRental.getUsers());
        System.out.println("Ole");

    }
}
