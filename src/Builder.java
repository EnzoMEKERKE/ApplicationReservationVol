/**
 * This is the interface for the implementation of the Builder design pattern
 * @author liciu
 */
public interface Builder {

    /**
     *
     * @param type - the type of the airplane
     */
    void setAeronefType(AeronefType type);

    /**
     *
     * @param airport - the current aiport from which the plane takes off
     */
    void setCurrentAirport(Airport airport);

    /**
     *
     * @param pilot - the pilot of the plane
     */
    void setPilot(Pilot pilot);

    /**
     *
     * @param capacity - the maximum number of passengers of the plane
     */
    void setCapacity(int capacity);

    /**
     *
     * @param priceKM - the price per kilometer of fuel
     */
    void setPriceKM(double priceKM);

    /**
     *
     * @param autonomie - the maximum number of kilometers that it can travel by only one stop
     */
    void setAutonomie(int autonomie);

    /**
     *
     * @param vitesse - the max speed of the airplane
     */
    void setVitesse(int vitesse);

    /**
     *
     * @param modelNumber - the model number of the plane
     */
    void setModelNumber(int modelNumber);
}
