import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    //user -> switch between admin and client + give menu for both;
    //use threads;

    public static void main(String[] args) {

       ArrayList<Reservation>reservations = new ArrayList<>();
      Admin u = new Admin("Liciu", "Stefan", "Cuza-Voda", "1211", 1);

      u.deleteReservation(reservations);

    }


}