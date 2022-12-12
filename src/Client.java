import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Client extends Utilisateur {

    private ArrayList<Reservation> reservations;

    public Client(String nom, String prenom, String adresse, String telephone) {
        super(nom, prenom, adresse, telephone);
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
            reservations.add(reservation);
    }

    public void addReservation(int price, String departure, String arrival, int id, Flight flight)
    {
        reservations.add(new Reservation(price, departure, arrival, id, false, flight));
    }

    public void deleteReservation(Reservation reservation) {
        for(Reservation res : reservations)
        {
            if(reservation.equals(res))
            {
                reservations.remove(res);
            }
        }
    }

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

    public void sortReservations() {
            SortingAlgos<Reservation> sortingReservations = new SortingAlgos<>();
            sortingReservations.mergeSort(this.reservations, 0, this.reservations.size() - 1);
    }

    public void seeReservations() {
        if(reservations.size() == 0) System.out.println("La liste est vide");
        for(Reservation res: reservations)
            System.out.println(res);
    }

    public void seeReservationByCity(String depart, HashMap<String, ArrayList<Reservation>>Map)
    {
        for(Reservation res : Map.get(depart))
        {
            System.out.println(res);
        }
    }

//    public void seeAllReservations() {
//
//    }

}
