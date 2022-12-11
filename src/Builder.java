public interface Builder {

    void setAeronefType(AeronefType type);

    void setCurrentAirport(Airport airport);
    void setPilot(Pilot pilot);
    void setCapacity(int capacity);
    void setPriceKM(double priceKM);
    void setAutonomie(int autonomie);
    void setVitesse(int vitesse);

    void setModelNumber(int modelNumber);
}
