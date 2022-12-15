/**
 * This class represents an airplane
 * @author liciu
 */
public class Aeronef implements Comparable<Aeronef> {
    private final AeronefType type;
    private Airport CurrentAirport;
    private final Pilot pilot;
    private final int capacity;
    private double priceKM;
    private final int autonomie;
    private final int vitesse;
    private final int modelNumber;

    /**
     * Constructor of the Aeronef class
     * @param type - the type of the airplane
     * @param currentAirport - the airport from which the plane is taking off
     * @param pilot - the pilot of the plane
     * @param capacity - the number of seats of the plane
     * @param priceKM - the price of fuel per kilometer
     * @param autonomie - the number of kilometers that it can travel with a single stop
     * @param vitesse - the max speed of the plane
     * @param modelNumber - the model number of the plane
     */
    protected Aeronef(AeronefType type, Airport currentAirport, Pilot pilot, int capacity, double priceKM, int autonomie, int vitesse, int modelNumber) {
        this.type = type;
        CurrentAirport = new Airport(currentAirport);
        this.pilot = new Pilot(pilot);
        this.capacity = capacity;
        this.priceKM = priceKM;
        this.autonomie = autonomie;
        this.vitesse = vitesse;
        this.modelNumber = modelNumber;
    }


    /**
     * Returns the type of the plane
     * @return type - type of the plane
     */
    public AeronefType getType() {
        return type;
    }

    /**
     * Returns the airport from which the plane takes off
     * @return airport from which it takes off
     */
    public Airport getCurrentAirport() {
        return CurrentAirport;
    }

    /**
     * Returns the pilot of the plane
     * @return pilot of the plane
     */
    public Pilot getPilot() {
        return pilot;
    }

    /**
     * Returns the capacity of the plane
     * @return capacity - maximum number of passangers
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns price per kilometer
     * @return priceKM - price of fuel to travel one kilometer
     */
    public double getPriceKM() {
        return priceKM;
    }

    /**
     * Returns the autonomy of the plane
     * @return autonomie - the maximum number of kilometers to travel in only one stop
     */
    public int getAutonomie() {
        return autonomie;
    }

    /**
     * Returns the max speed of the plane
     * @return vitesse - max speed of the plane
     */
    public int getVitesse() {
        return vitesse;
    }

    /**
     * Return the model number of the plane
     * @return current model number
     */
    public int getModelNumber() {
        return modelNumber;
    }

    /**
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Aeronef{" +
                "type=" + type +
                ", CurrentAirport=" + CurrentAirport +
                ", pilot=" + pilot +
                ", capacity=" + capacity +
                ", priceKM=" + priceKM +
                ", autonomie=" + autonomie +
                ", vitesse=" + vitesse +
                ", modelNumber=" + modelNumber +
                '}';
    }

    /**
     *
     * @param other the object to be compared.
     * @return an integer representing the result of the comparison
     */
    @Override
    public int compareTo(Aeronef other) {
        int AeronefComparison = this.type.compareTo(other.type);

        if (AeronefComparison != 0)
            return AeronefComparison;
        else {
            Integer firstCap = this.capacity;
            Integer secondCap = other.capacity;
            return firstCap.compareTo(secondCap);
        }
    }
}
