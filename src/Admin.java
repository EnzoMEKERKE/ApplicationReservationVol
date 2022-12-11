import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Utilisateur {

    private final int id_connection;

    public Admin(String nom, String prenom, String adresse, String telephone, int id_connection) {
        //check if id_connection already exists:
        super(nom, prenom, adresse, telephone);
        this.id_connection = id_connection;
    }

    //Adding reservations that will be accessible to all customers:
    public void addReservation(ArrayList<Reservation> reservations) {
        System.out.println("Please introduce data for the reservation that you are willing to add: ");
        Reservation r = Creator.createReservation();
        reservations.add(r);
        System.out.println("The reservation " + r.toString() + " has been added");
    }

    //Deleting a reservation that will no longer be accessible:
    public void deleteReservation(ArrayList<Reservation> reservations) {
        if(reservations.isEmpty())
        {
            System.out.println("There are currently no reservations available");
            return;
        }
        System.out.println("Currently available reservations: ");
        for(int i = 1; i <= reservations.size(); ++i)
            System.out.println(i + ". " + reservations.get(i - 1).toString());

        System.out.println("Select the number of the reservation that you would like to delete: ");
        Scanner scanner = new Scanner(System.in);
        int selectOption = scanner.nextInt();
        if(selectOption > reservations.size())
        {
            System.out.println("Invalid number");
        }
        else {
            reservations.remove(selectOption - 1);
        }

    }

//    public void addVol(ArrayList<Vol> ) {
//
//    }

//    public void deleteVol(ArrayList<Vol>) {
//
//    }

//    public void addAeroport(ArrayList<Aeroport>) {
//
//    }

    //public void deleteAeroport(ArrayList<Aeroport>) {
//
//    }

    //    public void addAeronef(ArrayList<Aeronef>) {
//
//    }

    //    public void deleteAeronef(ArrayList<Aeronef>) {
//
//    }

}
