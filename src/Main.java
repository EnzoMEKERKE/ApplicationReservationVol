import java.util.*;

public class Main {
    //user -> switch between admin and client + give menu for both;
    //use threads;

    public static void main(String[] args) {

       ArrayList<Reservation>reservations = new ArrayList<>();
       ArrayList<Flight>flights = new ArrayList<>();

       Admin u = new Admin("Liciu", "Stefan", "Cuza-Voda", "1211", 1);
       u.addReservation(reservations);
       //u.addVol(flights);

    }


}