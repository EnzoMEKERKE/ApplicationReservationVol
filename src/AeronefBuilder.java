/**
 * This class represents the builder for the Aeronef class
 * @author liciu
 */
public class AeronefBuilder implements Builder{
    private AeronefType type;
    private Airport CurrentAirport;
    private Pilot pilot;
    private int capacity;
    private double priceKM;
    private int autonomie;
    private int vitesse;
    private int modelNumber;


    /**
     * Sets the type of the plane - must take a value of type AeronefType
     * @param type - type of the plane
     */
    @Override
    public void setAeronefType(AeronefType type) {
        this.type = type;
    }

    /**
     * Sets the current airport
     * @param airport - object of type Airport
     */
    @Override
    public void setCurrentAirport(Airport airport)
    {
        this.CurrentAirport = new Airport(airport);
    }

    /**
     * Sets the current pilot of the plane
     * @param pilot - object of type Pilot
     */
    @Override
    public void setPilot(Pilot pilot) {
        this.pilot = new Pilot(pilot);
    }

    /**
     * Sets the capacity of the plane - must be an integer greater than 0
     * @param capacity - current max number of passengers
     */
    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Sets the price of fuel for one kilometer
     * @param priceKM - price of fuel as a double
     */
    @Override
    public void setPriceKM(double priceKM) {
        this.priceKM = priceKM;
    }

    /**
     * Sets the autonomy of the plane
     * @param autonomie - the max number of kilometers that it can travel in only one stop
     */
    @Override
    public void setAutonomie(int autonomie) {
        this.autonomie = autonomie;
    }

    /**
     * Sets the speed of the plane - must be an integer greater than 0
     * @param vitesse - the speed of the plane
     */
    @Override
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    /**
     * Sets the model number of the plane - must be an integer greater than 0
     * @param modelNumber - model number of the plane
     */
    @Override
    public void setModelNumber(int modelNumber)
    {
        this.modelNumber = modelNumber;
    }

    /**
     * This method is used to get an instance of an object of type Aeronef
     * @return the object of type Aeronef whose attributes were set using the setters of this class
     */
    public Aeronef getResult() {
        return new Aeronef(type, CurrentAirport,pilot, capacity, priceKM, autonomie,vitesse, modelNumber);
    }
}
