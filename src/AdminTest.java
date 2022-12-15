import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AdminTest {

    private Admin admin;

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

    }

    @Test
    void deleteReservation() {
    }

    @Test
    void addVol() {
    }

    @Test
    void deleteVol() {
    }

    @Test
    void addAeroport() {
    }

    @Test
    void deleteAeroport() {
    }

    @Test
    void addAeronef() {
    }

    @Test
    void deleteAeronef() {
    }
}