import java.util.Objects;

public class Vol {
    private String departure;
    private String arrival;
    private int idFlight;

    private Aeronef avion;
    private int nbPlacesOccupees;

    //dd/mm/yyyy
    private String departureDate;

    //dd/mm/yyyy
    private String arrivalDate;

    //0 - 24
    private String departureHour;

    //0 - 24
    private String arrivalHour;

    public Vol(String departure, String arrival, int idFlight, Aeronef avion,  int nbPlacesOccupees, String departureDate, String arrivalDate, String departureHour, String arrivalHour) {
        this.departure = departure;
        this.arrival = arrival;
        this.idFlight = idFlight;
        this.avion = avion;
        this.nbPlacesOccupees = nbPlacesOccupees;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureHour = departureHour;
        this.arrivalHour = arrivalHour;
    }

    public Vol(Vol other)
    {
        this.copy(other);
    }

    public void copy(Vol other)
    {
        this.setDeparture(other.getDeparture());
        this.setArrival(other.getArrival());
        this.setIdFlight(other.getIdFlight());
        this.setAvion(other.getAvion());
        this.setNbPlacesOccupees(other.getNbPlacesOccupees());
        this.setDepartureDate(other.getDepartureDate());
        this.setDepartureHour(other.getDepartureHour());
        this.setArrivalDate(other.getArrivalDate());
        this.setArrivalHour(other.getArrivalHour());
    }
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public int getNbPlacesOccupees() {
        return nbPlacesOccupees;
    }

    public void setNbPlacesOccupees(int nbPlacesOccupees) {
        this.nbPlacesOccupees = nbPlacesOccupees;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
    }

    public Aeronef getAvion() {
        return avion;
    }

    public void setAvion(Aeronef avion) {
        this.avion = avion;
    }

    public String getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(String arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vol vol = (Vol) o;
        return idFlight == vol.idFlight && nbPlacesOccupees == vol.nbPlacesOccupees && departure.equals(vol.departure) && arrival.equals(vol.arrival) && departureDate.equals(vol.departureDate) && arrivalDate.equals(vol.arrivalDate) && departureHour.equals(vol.departureHour) && arrivalHour.equals(vol.arrivalHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival, idFlight, nbPlacesOccupees, departureDate, arrivalDate, departureHour, arrivalHour);
    }

    @Override
    public String toString() {
        return "Vol{" +
                "departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", idFlight=" + idFlight +
                ", avion=" + avion +
                ", nbPlacesOccupees=" + nbPlacesOccupees +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureHour='" + departureHour + '\'' +
                ", arrivalHour='" + arrivalHour + '\'' +
                '}';
    }
}
