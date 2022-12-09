import java.util.ArrayList;

public class Admin extends Utilisateur {

    private int id_connection;

    public Admin(String nom, String prenom, String adresse, String telephone, int id_connection) {
        super(nom, prenom, adresse, telephone);
        this.id_connection = id_connection;
    }

    public void addReservation(ArrayList<Reservation> reservations) {

    }

    public void deleteReservation(ArrayList<Reservation> reservations) {

    }

//    public void addVol(ArrayList<Vol> ) {
//
//    }

//    public void deleteVol(ArrayList<Vol>) {
//
//    }

//    public void addAeroport(ArrayList<Aeroport>) {
//
//    }

    //public void deleteAeroport(ArrayList<Aeroport>) {
//
//    }

    //    public void addAeronef(ArrayList<Aeronef>) {
//
//    }

    //    public void deleteAeronef(ArrayList<Aeronef>) {
//
//    }

}
