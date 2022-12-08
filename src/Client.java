package Personnes;

import Partie_vol.Reservation;

import java.util.ArrayList;

public class Client extends Utilisateur {

    private ArrayList<Reservation> reservations;

    public Client(String nom, String prenom, String adresse, String telephone, ArrayList<Reservation> reservations) {
        super(nom, prenom, adresse, telephone);
        this.reservations = reservations;
    }

    public void addReservation(String departure, String arrival, int id) {

    }

    public void deleteReservation(String departure, String arrival, int id) {

    }

    public void deleteExpiredReservations() {

    }

    public void sortReservations() {

    }

    public void seeReservations(String departure, String arrival) {

    }

    public void seeAllReservations() {

    }

}
