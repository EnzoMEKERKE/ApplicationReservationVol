import java.util.Scanner;

/**
 * This class represents the Director in the Builder design pattern - used to instantiate an object of type Aeronef
 */
public class Director {
    final Scanner scanner = new Scanner(System.in);

    /**
     * Method used for constructing a plane of type DR400 with fixed parameters
     * @param builder - the builder object for the construction
     */
    public void constructFixedDR400(Builder builder)
    {
        builder.setAeronefType(AeronefType.DR400);
        builder.setCurrentAirport(new Airport("Marseille Provence", "Marseille"));
        builder.setPilot(new Pilot("Hugo", 20));
        builder.setCapacity(150);
        builder.setPriceKM(4.4);
        builder.setAutonomie(2400);
        builder.setVitesse(400);
        builder.setModelNumber(1221);
    }
    /**
     * Method used for constructing a plane of type CESSNA152 with fixed parameters
     * @param builder - the builder object for the construction
     */
    public void constructFixedCessna152(Builder builder)
    {
        builder.setAeronefType(AeronefType.CESSNA152);
        builder.setCurrentAirport(new Airport("Copenhagen Airport", "Copenhagen"));
        builder.setPilot(new Pilot("John", 20));
        builder.setCapacity(125);
        builder.setPriceKM(3.8);
        builder.setAutonomie(2000);
        builder.setVitesse(350);
        builder.setModelNumber(1234);
    }
    /**
     * Method used for constructing a plane of type Fouga Magister with fixed parameters
     * @param builder - the builder object for the construction
     */
    public void constructFixedFougaMagister(Builder builder)
    {
        builder.setAeronefType(AeronefType.FOUGA_MAGISTER);
        builder.setCurrentAirport(new Airport("Otopeni", "Bucharest"));
        builder.setPilot(new Pilot("Andrei", 20));
        builder.setCapacity(110);
        builder.setPriceKM(3.4);
        builder.setAutonomie(1850);
        builder.setVitesse(325);
        builder.setModelNumber(1341);
    }
    /**
     * Method used for constructing a plane of type PA28 with fixed parameters
     * @param builder - the builder object for the construction
     */
    public void constructFixedPA28(Builder builder)
    {
        builder.setAeronefType(AeronefType.PA28);
        builder.setCurrentAirport(new Airport("Cologne Bonn", "Koln Bon"));
        builder.setPilot(new Pilot("Heinz", 20));
        builder.setCapacity(100);
        builder.setPriceKM(3.0);
        builder.setAutonomie(1780);
        builder.setVitesse(330);
        builder.setModelNumber(4213);
    }

    /**
     * Method used for constructing a plane of type DR400 with input from user
     * @param builder - the builder object for the construction
     */
    public void constructDR400(Builder builder)
    {
        builder.setAeronefType(AeronefType.DR400);
        constructPlane(builder);
    }
    /**
     * Method used for constructing a plane of type CESSNA152 with input from user
     * @param builder - the builder object for the construction
     */
    public void constructCESSNA152(Builder builder)
    {
        builder.setAeronefType(AeronefType.CESSNA152);
        constructPlane(builder);
    }

    /**
     * Method used for constructing a plane of type Fouga Magister with input from user
     * @param builder - the builder object for the construction
     */
    public void constructFOUGA_MAGISTER(Builder builder)
    {
        builder.setAeronefType(AeronefType.FOUGA_MAGISTER);
        constructPlane(builder);

    }

    /**
     * Method used for constructing a plane of type PA28 with input from user
     * @param builder - the builder object for the construction
     */
    public void constructPA28(Builder builder)
    {
        builder.setAeronefType(AeronefType.PA28);
        constructPlane(builder);

    }

    /**
     * This method is used to construct any type of plane with input from the user
     * @param builder - the buildeer object for the construction
     */
    public void constructPlane(Builder builder)
    {
        scanner.nextLine();
        System.out.println("Please enter the name of the airport where the plane is taking off: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the city of the airport where the plane is taking off: ");
        String city = scanner.nextLine();

        builder.setCurrentAirport(new Airport(name, city));

        System.out.println("Please enter the capacity of the plane: ");
        builder.setCapacity(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Please enter the autonomy of the plane: ");
        builder.setAutonomie(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Please enter the name of the Pilot: ");
        String pilotName = scanner.nextLine();

        System.out.println("Please enter the age of the Pilot: ");
        builder.setPilot(new Pilot(pilotName, scanner.nextInt()));
        scanner.nextLine();

        System.out.println("Please enter the model number of the plane: ");
        builder.setModelNumber(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Please enter the price per kilometer of the plane: ");
        builder.setPriceKM(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Please enter the speed of the plane: ");
        builder.setVitesse(scanner.nextInt());
    }

}
