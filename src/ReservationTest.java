import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private Reservation reservation;
    private Flight flight;

    private Director director = new Director();

    private AeronefBuilder builder = new AeronefBuilder();

    Aeronef plane;
    @BeforeEach
    public void setUp() {
        director.constructFixedCessna152(builder);
        plane = builder.getResult();
        flight = new Flight("Marseille", "Paris", 1, plane, 0, "21/12/2022", "21/12/2022", "12:00", "13:00");
        reservation = new Reservation(100, "Paris", "Marseille", 2, false, flight);
    }

    @Test
    void getPrice() {
        assertEquals(reservation.getPrice(), 100);
    }

    @Test
    void setPrice() {
        reservation.setPrice(200);
        assertEquals(reservation.getPrice(), 200);
    }

    @Test
    void getDeparture() {
        assertEquals(reservation.getDeparture(), "Paris");
    }

    @Test
    void setDeparture() {
        reservation.setDeparture("Marignane");
        assertEquals(reservation.getDeparture(), "Marignane");
    }

    @Test
    void getArrival() {
        assertEquals(reservation.getArrival(), "Marseille");
    }

    @Test
    void setArrival() {
        reservation.setArrival("Bordeaux");
        assertEquals(reservation.getArrival(), "Bordeaux");
    }

    @Test
    void getId() {
        assertEquals(reservation.getId(), 2);
    }

    @Test
    void setId() {
        reservation.setId(3);
        assertEquals(reservation.getId(), 3);
    }

    @Test
    void isFull() {
        assertEquals(reservation.isFull(), false);
    }

    @Test
    void setFull() {
        reservation.setFull(true);
        assertEquals(reservation.isFull(), true);
    }

    @Test
    void getFlight() {
        assertEquals(reservation.getFlight(), flight);
    }

    @Test
    void setFlight() {
        Flight flight2 = new Flight("Marseille", "Marignane", 1, plane, 0, "21/12/2022", "21/12/2022", "12:00", "13:00");
        reservation.setFlight(flight2);
        assertEquals(reservation.getFlight(), flight2);
    }

    @Test
    void applyDiscount() {
        int priceBeforeDiscount = reservation.getPrice();
        reservation.applyDiscount(75);
        assertEquals(reservation.getPrice() , priceBeforeDiscount - 75);
    }
}
