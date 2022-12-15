import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * This class is used to create objects of different types with input from user
 */
public class Creator {
    private static int countVol = 0;
    static Director director = new Director();
    static AeronefBuilder builder = new AeronefBuilder();
    static Scanner scanner = new Scanner(System.in);

    /**
     * Method used to create an object of type reservation
     * @return object of type reservation
     */
    public static Reservation createReservation()
    {
        System.out.println("Please enter the price of the reservation: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the departure city: ");
        String Departure = scanner.nextLine();

        System.out.println("Please enter the arrival city: ");
        String Arrival = scanner.nextLine();

        System.out.println("Please enter the id of the reservation: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Flight f = createVol();
        return new Reservation(price, Departure, Arrival, id,false, f);
    }

    /**
     * Method used to create an object of type Pilot
     * @return object of type Pilot
     */
    public static Pilot createPilot()
    {
        Pilot p = new Pilot(null, 0);
        System.out.println("Please enter the name of the pilot: ");
        p.setName(scanner.nextLine());

        System.out.println("Please enter the age of the pilot: ");
        p.setAge(scanner.nextInt());
        scanner.nextLine();

        return p;
    }

    /**
     * Method used to create an object of type Airport
     * @return object of type Airport
     */
    public static Airport createAirport()
    {
        Airport a = new Airport(null, null);
        System.out.println("Please enter the name of the airport: ");
        a.setName(scanner.nextLine());

        System.out.println("Please enter the city of the Airport: ");
        a.setCity(scanner.nextLine());

        return a;
    }

    /**
     * Method used to create an object of type Aeronef
     * @return object of type Aeronef
     */
    public static Aeronef createAeronef()
    {
        System.out.println("Select the type of plane you would like to construct:\n 1. DR400 \n 2. CESSNA152 \n 3. FOUGA MAGISTER \n 4. PA28");
        int t = scanner.nextInt();
        switch (t) {
            case 1 -> director.constructDR400(builder);
            case 2 -> director.constructCESSNA152(builder);
            case 3 -> director.constructFOUGA_MAGISTER(builder);
            case 4 -> director.constructPA28(builder);
            default -> System.out.println("Selected type doesn't exist");
        }

        return builder.getResult();
    }

    /**
     * Method used to create an object of type Flight
     * @return object of type Flight
     */
    public static Flight createVol(Reservation r)
    {
        String departure = r.getDeparture();
        String arrival = r.getArrival();
        int idFlight = countVol++;

        Aeronef avion = createAeronef();

        scanner.nextLine();
        //Check departureDate to follow format:
        String departureDate;
        do {
            System.out.println("Please enter the departure date in format 'dd/mm/yyyy' : ");

            departureDate = scanner.nextLine();
        } while (!isValidDate(departureDate));

        //Check arrivalDate to follow format;
        String arrivalDate;
        do {
            System.out.println("Please enter the arrival date in format 'dd/mm/yyyy' : ");

            arrivalDate = scanner.nextLine();
        } while (!isValidDate(arrivalDate) || arrivalDate.compareTo(departureDate) < 0);

        String departureHour;
        do {
            System.out.println("Please enter the departure hour in format 'HH:mm' : ");

            departureHour = scanner.nextLine();
        } while (!isValidHour(departureHour));

        String arrivalHour;
        do {
            System.out.println("Please enter the arrival hour in format 'HH:mm' : ");

            arrivalHour = scanner.nextLine();
        } while (!isValidHour(arrivalHour) || (departureDate.compareTo(arrivalDate) == 0 && arrivalHour.compareTo(departureHour) < 0));

        return new Flight(departure, arrival, idFlight, avion, 0, departureDate, arrivalDate, departureHour, arrivalHour);
    }
    public static Flight createVol()
    {
        System.out.println("Please enter the departure city: ");
        String departure = scanner.nextLine();
        System.out.println("Please enter the arrival city: ");
        String arrival = scanner.nextLine();
        int idFlight = countVol++;

        Aeronef avion = createAeronef();

        scanner.nextLine();
        //Check departureDate to follow format:
        String departureDate;
        do {
            System.out.println("Please enter the departure date in format 'dd/mm/yyyy' : ");

            departureDate = scanner.nextLine();
        } while (!isValidDate(departureDate));

        //Check arrivalDate to follow format;
        String arrivalDate;
        do {
            System.out.println("Please enter the arrival date in format 'dd/mm/yyyy' : ");

            arrivalDate = scanner.nextLine();
        } while (!isValidDate(arrivalDate) || arrivalDate.compareTo(departureDate) < 0);

        String departureHour;
        do {
            System.out.println("Please enter the departure hour in format 'HH:mm' : ");

            departureHour = scanner.nextLine();
        } while (!isValidHour(departureHour));

        String arrivalHour;
        do {
            System.out.println("Please enter the arrival hour in format 'HH:mm' : ");

            arrivalHour = scanner.nextLine();
        } while (!isValidHour(arrivalHour) || (departureDate.compareTo(arrivalDate) == 0 && arrivalHour.compareTo(departureHour) < 0));

        return new Flight(departure, arrival, idFlight, avion, 0, departureDate, arrivalDate, departureHour, arrivalHour);
    }

    /**
     * Method to check is a string is a valid date of format dd/MM/yyyy
     * @param date - a string representing departure date or arrival date
     * @return true if the string is a valid date type, false otherwise
     */
    public static boolean isValidDate(String date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date.trim());

        } catch(ParseException p)
        {
            System.out.println("Invalid format");
            return false;
        }
        return true;
    }

    /**
     * Method to check is a string is a valid hour of format HH:mm
     * @param hour - a string representing departure hour or arrival hour
     * @return true if the string is a valid hour type, false otherwise
     */
    public static boolean isValidHour(String hour)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(hour.trim());

        } catch(ParseException p)
        {
            System.out.println("Invalid format");
            return false;
        }
        return true;
    }
}
