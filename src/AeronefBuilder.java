public class AeronefBuilder implements Builder{
    private AeronefType type;
    private Airport CurrentAirport;
    private Pilot pilot;
    private int capacity;
    private double priceKM;
    private int autonomie;
    private int vitesse;
    private int modelNumber;


    @Override
    public void setAeronefType(AeronefType type) {
        this.type = type;
    }

    @Override
    public void setCurrentAirport(Airport airport)
    {
        this.CurrentAirport = new Airport(airport);
    }
    @Override
    public void setPilot(Pilot pilot) {
        this.pilot = new Pilot(pilot);
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setPriceKM(double priceKM) {
        this.priceKM = priceKM;
    }

    @Override
    public void setAutonomie(int autonomie) {
        this.autonomie = autonomie;
    }

    @Override
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    @Override
    public void setModelNumber(int modelNumber)
    {
        this.modelNumber = modelNumber;
    }

    public Aeronef getResult() {
        return new Aeronef(type, CurrentAirport,pilot, capacity, priceKM, autonomie,vitesse, modelNumber);
    }
}
