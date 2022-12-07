public class AeronefBuilder implements Builder{
    private AeronefType type;
    private Airport CurrentAirport;
    private Pilot pilot;
    private int capacity;
    private double priceKM;
    private int autonomie;
    private int vitesse;
    private int model_number;


    @Override
    public void setAeronefType(AeronefType type) {
        this.type = type;
    }

    @Override
    public void setCurrentAirport(Airport airport)
    {
        this.CurrentAirport = airport;
    }
    @Override
    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setPriceKM(int priceKM) {
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
        this.model_number  = modelNumber;
    }

    public Aeronef getResult() {
        return new Aeronef(type, CurrentAirport,pilot, capacity, priceKM, autonomie,vitesse, model_number);
    }
}
