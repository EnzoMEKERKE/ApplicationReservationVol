import java.util.Objects;

/**
 * This class represents a flight
 * @author Enzo Mekerke
 */
public class Flight {
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

    /**
     * Constructor of the Flight class
     * @param departure - the departure city of the flight
     * @param arrival - the arrival city of the flight
     * @param idFlight - the id of the flight
     * @param avion - the plane used in this flight
     * @param nbPlacesOccupees - the number of places that are no longer available
     * @param departureDate - the departure date of the flight
     * @param arrivalDate - the arrival date of the flight
     * @param departureHour - the departure hour of the flight
     * @param arrivalHour - the arrival hour of the flight
     */
    public Flight(String departure, String arrival, int idFlight, Aeronef avion, int nbPlacesOccupees, String departureDate, String arrivalDate, String departureHour, String arrivalHour) {
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

    /**
     * Copy constructor for the flight class
     * @param other - another object of type flight
     */
    public Flight(Flight other)
    {
        this.copy(other);
    }

    /**
     * Method used to copy the attributes from another object
     * @param other - another object of type flight
     */
    public void copy(Flight other)
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

    /**
     *
     * @return the departure city of the flight
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * Sets the departure city of the flight
     * @param departure the current departure city of the flight
     */
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /**
     *
     * @return the arrival city of the flight
     */
    public String getArrival() {
        return arrival;
    }

    /**
     * Sets the arrival city of the flight
     * @param arrival - current arrival city of the flight
     */
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    /**
     *
     * @return the id of the flight
     */
    public int getIdFlight() {
        return idFlight;
    }

    /**
     * Sets the id of the flight
     * @param idFlight - current if of the flight
     */
    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    /**
     *
     * @return the number of places that are no longer available
     */
    public int getNbPlacesOccupees() {
        return nbPlacesOccupees;
    }

    /**
     * Sets the number of places that are no longer available
     * @param nbPlacesOccupees - number of places that are no longer available
     */
    public void setNbPlacesOccupees(int nbPlacesOccupees) {
        this.nbPlacesOccupees = nbPlacesOccupees;
    }

    /**
     *
     * @return the departure date
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the departure date - must be of format dd/MM/yyyy
     * @param departureDate - departure date of the flight
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     *
     * @return the arrival date
     */
    public String getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the arrival date - must be of format dd/MM/yyyy
     * @param arrivalDate - arrival date of the flight
     */
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     *
     * @return the departure hour
     */
    public String getDepartureHour() {
        return departureHour;
    }

    /**
     * Sets the departure hour - must be of format HH:mm
     * @param departureHour - departure hour of the flight
     */
    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
    }

    /**
     *
     * @return the plane
     */
    public Aeronef getAvion() {
        return avion;
    }

    /**
     *
     * @param avion - the current plane
     */
    public void setAvion(Aeronef avion) {
        this.avion = avion;
    }

    /**
     *
     * @return - the arrival hour of the flight
     */
    public String getArrivalHour() {
        return arrivalHour;
    }

    /**
     * Sets the arrival hour  - must be of format HH:mm
     * @param arrivalHour - the arrival hour of the flight
     */
    public void setArrivalHour(String arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return idFlight == flight.idFlight && nbPlacesOccupees == flight.nbPlacesOccupees && departure.equals(flight.departure) && arrival.equals(flight.arrival) && departureDate.equals(flight.departureDate) && arrivalDate.equals(flight.arrivalDate) && departureHour.equals(flight.departureHour) && arrivalHour.equals(flight.arrivalHour);
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
