import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilotTest {

    private Pilot pilot;

    @BeforeEach
    public void setUp()  {
        pilot = new Pilot("Enzo", 19);
    }
    @Test
    void getName() {
        assertEquals(pilot.getName(), "MEKERKE");
    }

    @Test
    void setName() {
        pilot.setName("Enzo");
        assertEquals(pilot.getName(), "Enzo");
    }

    @Test
    void setAge() {
        pilot.setAge(21);
        assertEquals(pilot.getAge(), 21);
    }

    @Test
    void getAge() {
        assertEquals(pilot.getAge(), 19);
    }
}
