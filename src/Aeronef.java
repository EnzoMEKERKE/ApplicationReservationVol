public class Aeronef {
    private final AeronefType type;
    private Airport CurrentAirport;
    private final Pilot pilot;
    private final int capacity;
    private double priceKM;
    private final int autonomie;
    private final int vitesse;
    private final int model_number;

    public Aeronef(AeronefType type, Airport currentAirport, Pilot pilot, int capacity, double priceKM, int autonomie, int vitesse, int model_number) {
        this.type = type;
        CurrentAirport = currentAirport;
        this.pilot = pilot;
        this.capacity = capacity;
        this.priceKM = priceKM;
        this.autonomie = autonomie;
        this.vitesse = vitesse;
        this.model_number = model_number;
    }

    public AeronefType getType() {
        return type;
    }

    public Airport getCurrentAirport() {
        return CurrentAirport;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPriceKM() {
        return priceKM;
    }

    public int getAutonomie() {
        return autonomie;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getModel_number() {
        return model_number;
    }
}
