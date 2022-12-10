import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static int countVol = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Director director = new Director();
        AeronefBuilder builder = new AeronefBuilder();
        director.constructDR400(builder);
        Aeronef aeronef1 = builder.getResult();
        System.out.println(aeronef1);

    }

    public static Aeronef createAeronef()
    {
        return null;
    }

    public static Vol createVol(Scanner scanner)
    {
        System.out.println("Please enter the departure city: ");
        String departure = scanner.nextLine();
        System.out.println("Please enter the arrival city: ");
        String arrival = scanner.nextLine();
        int idFlight = countVol++;

        Aeronef avion = createAeronef();

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

        return new Vol(departure, arrival, idFlight, avion, 0, departureDate, arrivalDate, departureHour, arrivalHour);
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