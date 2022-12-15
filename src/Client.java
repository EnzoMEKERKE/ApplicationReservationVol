import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * This class represents a client of the application
 * @author liciu
 * @author Enzo Mekerke
 */
public class Client extends Utilisateur {

    private ArrayList<Reservation> reservations;

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Constructor of the client class
     * @param nom - represents the name of the client
     * @param prenom - represents the final name of the client
     * @param adresse - represents the address of the client
     * @param telephone - represents the phone number of the client
     */
    public Client(String nom, String prenom, String adresse, String telephone) {
        super(nom, prenom, adresse, telephone);
        this.reservations = new ArrayList<>();
    }

    /**
     * Method used to add a new reservation to the Client's list of reservations
     * @param reservation - an object of type reservation that will be added to the list
     */
    public void addReservation(Reservation reservation) {
            reservations.add(reservation);
    }

    public void addReservation(int price, String departure, String arrival, int id, Flight flight)
    {
        reservations.add(new Reservation(price, departure, arrival, id, false, flight));
    }

    /**
     * Method used to delete a reservation from the Client's list of reservations
     * @param reservation - the reservation to be deleted
     */
    public void deleteReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    /**
     * Method used to delete the reservations that have already expired
     * @throws ParseException - if the departure or arrival date cannot be parsed
     */
    public void deleteExpiredReservations() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.println(date);
        for(Reservation res : reservations)
        {
            Date departureDate = new SimpleDateFormat("dd/MM/yyyy").parse(res.getFlight().getDepartureDate());
            System.out.println(departureDate);
            System.out.println(departureDate.compareTo(date));
            if(departureDate.compareTo(date) < 0)
            {
                reservations.remove(res);
                break;
            }
        }
    }

    /**
     * Method used to sort a list of reservations using merge sort or quicksort algorithm
     */
    public void sortReservations() {
            SortingAlgos<Reservation> sortingReservations = new SortingAlgos<>();
            sortingReservations.mergeSort(this.reservations, 0, this.reservations.size() - 1);
    }

    /**
     * Method used to print all current reservations of the client
     */
    public void seeReservations() {
        if(reservations.size() == 0) System.out.println("La liste est vide");
        for(int i = 0; i < reservations.size(); ++i)
            System.out.println(i + ". " + reservations.get(i).toString());
    }

    /**
     * Method used to print all the reservations of the client that have a specific departure city
     * @param depart - departure city
     * @param Map - hashmap of reservations
     */
    public void seeReservationByCity(String depart, HashMap<String, ArrayList<Reservation>>Map)
    {
        for(Reservation res : Map.get(depart))
        {
            System.out.println(res);
        }
    }

    /**
     * Method used to print all the reservations of the client that have a specific departure city and a specific arrival city
     * @param departure - departure city
     * @param arrival - arrival city
     * @param Map - hashmap of reservations
     */
    public void seeReservationByDepartureAndArrival(String departure, String arrival,  HashMap<String, ArrayList<Reservation>>Map)
    {
        for(Reservation res : Map.get(departure))
        {
            if(res.getArrival().equals(arrival))
                 System.out.println(res);
        }
    }

}
