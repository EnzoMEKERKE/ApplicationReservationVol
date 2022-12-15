import java.util.ArrayList;
import java.util.Objects;

/**
 * This abstract class represents a user of the application
 */
public abstract class Utilisateur {
    String nom;
    String prenom;
    String adresse;
    String telephone;

    /**
     * The constructor of the Utisateur class
     * @param nom - the name of the user
     * @param prenom - the final name of the user
     * @param adresse - the address of the user
     * @param telephone - the phone number of the user
     */
    public Utilisateur(String nom, String prenom,  String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public void addReservation(ArrayList<Reservation> reservations)
    {
        System.out.println("Class utilisateur");
    }

    /**
     *
     * @return the name of the user
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom the name of the user
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     *
     * @return the final name of the user
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @param prenom the final name of the user
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return the address of the user
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @param adresse the address of the user
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     *
     * @return the phone number of the user
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     *
     * @param telephone the phone number of the user
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return nom.equals(that.nom) && prenom.equals(that.prenom) && adresse.equals(that.adresse) && telephone.equals(that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, adresse, telephone);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
