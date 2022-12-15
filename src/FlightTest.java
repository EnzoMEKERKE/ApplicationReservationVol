import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FlightTest {

    private Flight flight;

    private Director director = new Director();

    private AeronefBuilder builder = new AeronefBuilder();

    Aeronef plane;
    @BeforeEach
    public void setUp()  {
        director.constructFixedCessna152(builder);
        plane = builder.getResult();
        flight = new Flight("Marseille", "Paris", 1, plane, 0, "21/12/2022", "21/12/2022", "12:00", "13:00");
    }

    @Test
    void copy() {
    }

    @Test
    void getDeparture() {
        assertEquals(flight.getDeparture(), "Marseille");
    }

    @Test
    void setDeparture() {
        flight.setDeparture("Marignane");
        assertEquals(flight.getDeparture(), "Marignane");
    }

    @Test
    void getArrival() {
        assertEquals(flight.getArrival(), "Paris");
    }

    @Test
    void setArrival() {
        flight.setArrival("Bordeaux");
        assertEquals(flight.getArrival(), "Bordeaux");
    }

    @Test
    void getIdFlight() {
        assertEquals(flight.getIdFlight(), 1);
    }

    @Test
    void setIdFlight() {
        flight.setIdFlight(42);
        assertEquals(flight.getIdFlight(), 42);
    }

    @Test
    void getNbPlacesOccupees() {
        assertEquals(flight.getNbPlacesOccupees(), 12);
    }

    @Test
    void setNbPlacesOccupees() {
        flight.setNbPlacesOccupees(7);
        assertEquals(flight.getNbPlacesOccupees(), 7);
    }

    @Test
    void getDepartureDate() {
        assertEquals(flight.getDepartureDate(), "21/12/2022");
    }

    @Test
    void setDepartureDate() {
        flight.setDepartureDate("01/01/2023");
        assertEquals(flight.getDepartureDate(), "01/01/2023");
    }

    @Test
    void getArrivalDate() {
        assertEquals(flight.getArrivalDate(), "21/12/2022");
    }

    @Test
    void setArrivalDate() {
        flight.setArrivalDate("02/01/2023");
        assertEquals(flight.getArrivalDate(), "02/01/2023");
    }

    @Test
    void getDepartureHour() {
        assertEquals(flight.getDepartureHour(), "12:00");
    }

    @Test
    void setDepartureHour() {
        flight.setDepartureHour("21:00");
        assertEquals(flight.getDepartureHour(), "21:00");
    }

    @Test
    void getAvion() {
        assertEquals(flight.getAvion(), plane);
    }

    @Test
    void setAvion() {
        Aeronef plane2;
        director.constructFixedDR400(builder);
        plane2 = builder.getResult();
        flight.setAvion(plane2);
        assertEquals(flight.getAvion(), plane2);
    }

    @Test
    void getArrivalHour() {
        assertEquals(flight.getArrivalHour(), "13:00");
    }

    @Test
    void setArrivalHour() {
        flight.setArrivalHour("18:00");
        assertEquals(flight.getArrivalHour(), "18:00");
    }
}
