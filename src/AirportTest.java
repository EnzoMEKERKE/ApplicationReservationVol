import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    private Airport airport;

    @BeforeEach
    public void setUp() {
        airport = new Airport("CDG", "Paris");
    }

    @Test
    void getName() {
        assertEquals(airport.getName(), "CDG");
    }

    @Test
    void setName() {
        airport.setName("Orly");
        assertEquals(airport.getName(), "Orly");
    }

    @Test
    void getCity() {
        assertEquals(airport.getCity(), "Paris");
    }

    @Test
    void setCity() {
        airport.setCity("Marignane");
        assertEquals(airport.getCity(), "Marignane");
    }
}
