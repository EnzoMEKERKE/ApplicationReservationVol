import java.util.Scanner;

public class Director {
    final Scanner scanner = new Scanner(System.in);

    public void constructDR400(Builder builder)
    {
        builder.setAeronefType(AeronefType.DR400);
        constructPlane(builder);
    }

    public void constructCESSNA152(Builder builder)
    {
        builder.setAeronefType(AeronefType.CESSNA152);
        constructPlane(builder);
    }

    public void constructFOUGA_MAGISTER(Builder builder)
    {
        builder.setAeronefType(AeronefType.FOUGA_MAGISTER);
        constructPlane(builder);

    }

    public void constructPA28(Builder builder)
    {
        builder.setAeronefType(AeronefType.PA28);
        constructPlane(builder);

    }

    public void constructPlane(Builder builder)
    {
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
