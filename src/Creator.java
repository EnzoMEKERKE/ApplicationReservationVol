import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Creator {
    public static int countVol = 0;
    static Director director = new Director();
    static AeronefBuilder builder = new AeronefBuilder();
    static Scanner scanner = new Scanner(System.in);

    public static Reservation createReservation()
    {
        Reservation r = new Reservation(0, null, null, 0, false, new Flight(null, null, 0, null, 0, null, null, null, null));
        System.out.println("Please enter the price of the reservation: ");
        r.setPrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Please enter the departure city: ");
        r.setDeparture(scanner.nextLine());

        System.out.println("Please enter the arrival city: ");
        r.setArrival(scanner.nextLine());

        System.out.println("Please enter the id of the reservation: ");
        r.setId(scanner.nextInt());
        scanner.nextLine();

        r.setFlight(createVol(r));
        return r;
    }

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

    public static Airport createAirport()
    {
        Airport a = new Airport(null, null);
        System.out.println("Please enter the name of the airport: ");
        a.setName(scanner.nextLine());

        System.out.println("Please enter the city of the Airport: ");
        a.setCity(scanner.nextLine());

        return a;
    }

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
