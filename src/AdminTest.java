import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class AdminTest {

    private Admin admin;
    private final Director director = new Director();
    private final AeronefBuilder builder = new AeronefBuilder();

    @BeforeEach
    public void setUp() {
        admin = new Admin("Mekerke", "Enzo", "Marseille", "0698716437", 1);
    }

    @Test
    void getId_connection() {
        assertEquals(admin.getId_connection(), 1);
    }

    @Test
    void addReservation() {

        director.constructFixedCessna152(builder);
        Aeronef plane = builder.getResult();
        Flight f = new Flight("Marseille Provence", "Otopeni", 0, plane, 0, "10/01/2022", "11/01/2022", "18:10", "00:33");
        Reservation r = new Reservation(150, "Marseille", "Otopeni", 6, false, f);
        ArrayList<Reservation>ReservationsBeforeAdding = new ArrayList<>(Main.reservations);
        admin.addReservation(Main.reservations);
        ReservationsBeforeAdding.add(r);
        assertArrayEquals(ReservationsBeforeAdding.toArray(), Main.reservations.toArray());
    }

    @Test
    void deleteReservation() {
        director.constructFixedCessna152(builder);
        Aeronef plane = builder.getResult();
        Flight f = new Flight("Marseille Provence", "Otopeni", 0, plane, 0, "10/01/2022", "11/01/2022", "18:10", "00:33");
        Reservation r = new Reservation(150, "Marseille", "Otopeni", 6, false, f);

        Main.reservations.add(r);
        ArrayList<Reservation>ReservationsBeforeDelete = new ArrayList<>(Main.reservations);
        System.out.println(Main.reservations);
        ReservationsBeforeDelete.remove(0);
        admin.deleteReservation(Main.reservations);
        assertArrayEquals(Main.reservations.toArray(), ReservationsBeforeDelete.toArray());
    }

    @Test
    void addFlight() {
        director.constructFixedCessna152(builder);
        Aeronef plane = builder.getResult();
        Flight f = new Flight("Marseille Provence", "Otopeni", 0, plane, 0, "10/01/2022", "11/01/2022", "18:10", "00:33");

        ArrayList<Flight> FlightsBeforeAdd = new ArrayList<>(Main.flights);
        FlightsBeforeAdd.add(f);
        admin.addFlight(Main.flights);
        assertArrayEquals(Main.flights.toArray(), FlightsBeforeAdd.toArray());
    }

    @Test
    void deleteFlight() {
        director.constructFixedCessna152(builder);
        Aeronef plane = builder.getResult();
        Flight f = new Flight("Marseille Provence", "Otopeni", 0, plane, 0, "10/01/2022", "11/01/2022", "18:10", "00:33");

        Main.flights.add(f);
        ArrayList<Flight>FlightsBeforeDelete = new ArrayList<>(Main.flights);
        FlightsBeforeDelete.remove(0);
        admin.deleteFlight(Main.flights);
        assertArrayEquals(Main.flights.toArray(), FlightsBeforeDelete.toArray());

    }

    @Test
    void addAeroport() {
        ArrayList<Airport>AirportsBeforeAdd = new ArrayList<>(Main.airports);

        Airport a = new Airport("Amsterdam", "Amsterdam");
        admin.addAirport(Main.airports);
        AirportsBeforeAdd.add(a);
        assertArrayEquals(Main.airports.toArray(), AirportsBeforeAdd.toArray());

    }

    @Test
    void deleteAeroport() {
        Airport a = new Airport("Amsterdam", "Amsterdam");
        Main.airports.add(a);
        ArrayList<Airport>AirportsBeforeDelete = new ArrayList<>(Main.airports);

        AirportsBeforeDelete.remove(0);
        admin.deleteAirport(Main.airports);
        assertArrayEquals(Main.airports.toArray(), AirportsBeforeDelete.toArray());

    }

    @Test
    void addAeronef() {
        director.constructFixedCessna152(builder);
        Aeronef plane = builder.getResult();

        ArrayList<Aeronef> PlanesBeforeAdd = new ArrayList<>(Main.planes);
        admin.addAeronef(Main.planes);
        PlanesBeforeAdd.add(plane);
        assertArrayEquals(Main.planes.toArray(), PlanesBeforeAdd.toArray());

    }

    @Test
    void deleteAeronef() {
        director.constructFixedCessna152(builder);
        Aeronef plane = builder.getResult();
        Main.planes.add(plane);
        ArrayList<Aeronef> PlanesBeforeDelete = new ArrayList<>(Main.planes);

        PlanesBeforeDelete.remove(0);
        admin.deleteAeronef(Main.planes);
        assertArrayEquals(Main.planes.toArray(), PlanesBeforeDelete.toArray());
    }
}