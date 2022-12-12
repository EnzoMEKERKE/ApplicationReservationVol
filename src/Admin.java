import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Utilisateur {

    private final int id_connection;

    public Admin(String nom, String prenom, String adresse, String telephone, int id_connection) {
        //check if id_connection already exists:
        super(nom, prenom, adresse, telephone);
        this.id_connection = id_connection;
    }

    public int getId_connection()
    {
        return id_connection;
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

   public void addVol(ArrayList<Flight> flights) {
       System.out.println("Please introduce data for the flight that you are willing to add: ");
       Flight v = Creator.createVol();
       flights.add(v);
       System.out.println("The flight " + v.toString() + " has been added");
    }

    public void deleteVol(ArrayList<Flight> flights) {
        if(flights.isEmpty())
        {
            System.out.println("There are currently no flights available");
            return;
        }
        System.out.println("Currently available flights: ");
        for(int i = 1; i <= flights.size(); ++i)
            System.out.println(i + ". " + flights.get(i - 1).toString());

        System.out.println("Select the number of the flight that you would like to delete: ");
        Scanner scanner = new Scanner(System.in);
        int selectOption = scanner.nextInt();
        if(selectOption > flights.size())
        {
            System.out.println("Invalid number");
        }
        else {
            flights.remove(selectOption - 1);
        }
    }

    public void addAeroport(ArrayList<Airport> airports) {
        System.out.println("Please introduce data for the airport that you are willing to add: ");
        Airport a = Creator.createAirport();
        airports.add(a);
        System.out.println("The airport " + a.toString() + " has been added");
    }

    public void deleteAeroport(ArrayList<Airport> airports ) {
        if(airports.isEmpty())
        {
            System.out.println("There are currently no airports available");
            return;
        }
        System.out.println("Currently available airports: ");
        for(int i = 1; i <= airports.size(); ++i)
            System.out.println(i + ". " + airports.get(i - 1).toString());

        System.out.println("Select the number of the airport that you would like to delete: ");
        Scanner scanner = new Scanner(System.in);
        int selectOption = scanner.nextInt();
        if(selectOption > airports.size())
        {
            System.out.println("Invalid number");
        }
        else {
            airports.remove(selectOption - 1);
        }
    }

    public void addAeronef(ArrayList<Aeronef> planes) {
        System.out.println("Please introduce data for the plane that you are willing to add: ");
        Aeronef a = Creator.createAeronef();
        planes.add(a);
        System.out.println("The plane " + a.toString() + " has been added");
    }

    public void deleteAeronef(ArrayList<Aeronef> planes) {
        if(planes.isEmpty())
        {
            System.out.println("There are currently no planes available");
            return;
        }
        System.out.println("Currently available planes: ");
        for(int i = 1; i <= planes.size(); ++i)
            System.out.println(i + ". " + planes.get(i - 1).toString());

        System.out.println("Select the number of the plane that you would like to delete: ");
        Scanner scanner = new Scanner(System.in);
        int selectOption = scanner.nextInt();
        if(selectOption > planes.size())
        {
            System.out.println("Invalid number");
        }
        else {
            planes.remove(selectOption - 1);
        }

    }
}
