public class Director {

    public void constructDR400(Builder builder)
    {
        builder.setAeronefType(AeronefType.DR400);
        builder.setCurrentAirport(new Airport("Otopeni", "Bucharest"));
        builder.setCapacity(100);
        builder.setAutonomie(500);
        builder.setPilot(new Pilot("Liciu", 21));
        builder.setModelNumber(1231331);
        builder.setPriceKM(3);
        builder.setVitesse(350);

    }

    public void constructCESSNA152(Builder builder)
    {
        builder.setAeronefType(AeronefType.CESSNA152);
        builder.setCurrentAirport(new Airport("Otopeni", "Bucharest"));
        builder.setCapacity(100);
        builder.setAutonomie(500);
        builder.setPilot(new Pilot("Liciu", 21));
        builder.setModelNumber(1231331);
        builder.setPriceKM(3);
        builder.setVitesse(350);
    }

    public void constructFOUGA_MAGISTER(Builder builder)
    {
        builder.setAeronefType(AeronefType.FOUGA_MAGISTER);
        builder.setCurrentAirport(new Airport("Otopeni", "Bucharest"));
        builder.setCapacity(100);
        builder.setAutonomie(500);
        builder.setPilot(new Pilot("Liciu", 21));
        builder.setModelNumber(1231331);
        builder.setPriceKM(3);
        builder.setVitesse(350);
    }

    public void constructPA28(Builder builder)
    {
        builder.setAeronefType(AeronefType.PA28);
        builder.setCurrentAirport(new Airport("Otopeni", "Bucharest"));
        builder.setCapacity(100);
        builder.setAutonomie(500);
        builder.setPilot(new Pilot("Liciu", 21));
        builder.setModelNumber(1231331);
        builder.setPriceKM(3);
        builder.setVitesse(350);
    }

}
