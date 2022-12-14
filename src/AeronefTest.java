import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class AeronefTest {

    private Aeronef aeronef;

    @BeforeEach
    public void setUp()  {
        aeronef = new Aeronef(AeronefType.CESSNA152, new Airport("CDG", "Paris"), new Pilot("Enzo", 19), 10, 1.1, 100, 1000, 25);
    }

    @Test
    void getType() {
        assertEquals(aeronef.getType(), AeronefType.CESSNA152);
    }

    @Test
    void getCurrentAirport() {
        assertEquals(aeronef.getCurrentAirport().getName(), "CDG");
        assertEquals(aeronef.getCurrentAirport().getCity(), "Paris");
    }

    @Test
    void getPilot() {
      assertEquals(aeronef.getPilot().getName(), "Enzo");
      assertEquals(aeronef.getPilot().getAge(), 19);
    }

    @Test
    void getCapacity() {
        assertEquals(aeronef.getCapacity(), 10);
    }

    @Test
    void getPriceKM() {
        assertEquals(aeronef.getPriceKM(), 1.1);
    }

    @Test
    void getAutonomie() {
        assertEquals(aeronef.getAutonomie(), 100);
    }

    @Test
    void getVitesse() {
        assertEquals(aeronef.getVitesse(), 1000);
    }

    @Test
    void getModel_number() {
        assertEquals(aeronef.getModel_number(), 25);
    }

    @Test
    void testToString() {

    }

    @Test
    void compareTo() {
    }
}