public class Aeronef implements Comparable<Aeronef> {
    private final AeronefType type;
    private Airport CurrentAirport;
    private final Pilot pilot;
    private final int capacity;
    private double priceKM;
    private final int autonomie;
    private final int vitesse;
    private final int model_number;

    protected Aeronef(AeronefType type, Airport currentAirport, Pilot pilot, int capacity, double priceKM, int autonomie, int vitesse, int model_number) {
        this.type = type;
        CurrentAirport = new Airport(currentAirport);
        this.pilot = new Pilot(pilot);
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
                ", model_number=" + model_number +
                '}';
    }

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
