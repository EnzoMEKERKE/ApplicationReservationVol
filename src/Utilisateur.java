import java.util.Objects;

public abstract class Utilisateur {
    String nom;
    String prenom;
    String adresse;
    String telephone;

    public Utilisateur(String nom, String prenom,  String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

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
