import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    Client c;
    Director director = new Director();
    AeronefBuilder builder = new AeronefBuilder();
    Reservation r;
    @BeforeEach
    public void setUp()
    {
        director.constructFixedCessna152(builder);
        Aeronef plane = builder.getResult();
        Flight f = new Flight("Marseille Provence", "Otopeni", 0, plane, 0, "10/12/2022", "12/12/2022", "18:10", "00:33");
        r = new Reservation(150, "Marseille", "Otopeni", 6, false, f);

        c = new Client("Stefan", "Liciu", "Cuza-Voda", "0751118678");
        c.getReservations().add(r);
    }
    @Test
    void getReservations() {
        ArrayList<Reservation> Reservations = new ArrayList<>();
        Reservations.add(r);

        assertArrayEquals(Reservations.toArray(), c.getReservations().toArray());

    }

    @Test
    void addReservation() {
        ArrayList<Reservation> ReservationsBeforeAdd = new ArrayList<>(c.getReservations());

        ReservationsBeforeAdd.add(r);
        c.addReservation(r);
        assertArrayEquals(ReservationsBeforeAdd.toArray(), c.getReservations().toArray());

    }

    @Test
    void deleteReservation() {
        ArrayList<Reservation> ReservationsBeforeDelete = new ArrayList<>(c.getReservations());
        System.out.println(ReservationsBeforeDelete);
        System.out.println(c.getReservations());
        c.deleteReservation(r);
        ReservationsBeforeDelete.remove(r);
        assertArrayEquals(ReservationsBeforeDelete.toArray(), c.getReservations().toArray());

    }

    @Test
    void deleteExpiredReservations() throws ParseException {
        ArrayList<Reservation>Reservations = new ArrayList<>(c.getReservations());
        Reservations.remove(r);
        c.deleteExpiredReservations();
        assertArrayEquals(Reservations.toArray(), c.getReservations().toArray());
    }
}