import java.text.ParseException;
import java.util.*;

/**
 * This represents the main class of the project
 */
public class Main {
    //user -> switch between admin and client + give menu for both;
    //use threads;
    static ArrayList<Reservation>reservations = new ArrayList<>();
    static ArrayList<Flight>flights = new ArrayList<>();
    static ArrayList<Aeronef>planes = new ArrayList<>();
    static ArrayList<Airport>airports = new ArrayList<>();

    static Admin admin = new Admin("Coucou", "Hugo", "Marseille", "1414141", 1);
    static HashMap<String, Client>clients = new HashMap<String, Client>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Create some base airports, base planes, base flights, base reservations
        //Airports:
        Airport airport1 = new Airport("Copenhagen Airport", "Copenhagen");
        Airport airport2 = new Airport("Helsinki Airport", "Helsinki");
        Airport airport3 = new Airport("Cologne Bonn", "Koln Bonn");
        Airport airport4 = new Airport("Otopeni", "Bucharest");
        Airport airport5 = new Airport("Marseille Provence", "Marseille");

        airports.add(airport1);
        airports.add(airport2);
        airports.add(airport3);
        airports.add(airport4);
        airports.add(airport5);

        //Planes:
        Director director = new Director();
        AeronefBuilder builder = new AeronefBuilder();
        director.constructFixedCessna152(builder);
        Aeronef plane1 = builder.getResult();

        director.constructFixedPA28(builder);
        Aeronef plane2 = builder.getResult();

        director.constructFixedDR400(builder);
        Aeronef plane3 = builder.getResult();

        director.constructFixedFougaMagister(builder);
        Aeronef plane4 = builder.getResult();

        director.constructFixedCessna152(builder);
        builder.setCurrentAirport(airport1);
        Aeronef plane5 = builder.getResult();

        planes.add(plane1);
        planes.add(plane2);
        planes.add(plane3);
        planes.add(plane4);
        planes.add(plane5);

        //Flights:
        //Nb places occupees -> change everytime we make a reservation
        Flight f1 = new Flight("Otopeni", "Marseille Provence", 1, plane4, 0, "20/12/2022", "21/12/2022", "13:33", "15:43");
        Flight f2 = new Flight("Copenhagen Airport", "Otopeni", 2, plane1, 0, "23/12/2022", "24/12/2022", "09:12", "12:29");
        Flight f3 = new Flight("Cologne Bonn", "Helsinki Airport", 3, plane2, 0, "02/01/2023", "02/01/2023", "16:00", "17:56");
        Flight f4 = new Flight("Marseille Provence", "Otopeni", 4, plane3, 0, "18/12/2022", "19/12/2022", "17:10", "00:12");
        Flight f5 = new Flight("Copenhagen Airport", "Marseille Provence", 5, plane5, 0, "10/12/2022", "10/12/2022", "03:55", "07:11");;

        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);
        flights.add(f5);

        //Reservations:
        Reservation r1 = new Reservation(150, "Otopeni", "Marseille", 1, false, f1);
        Reservation r2 = new Reservation(100, "Copenhagen Airport", "Otopeni", 2, false, f2);
        Reservation r3 = new Reservation(200, "Cologne Bonn", "Helsinki Airport", 3, false, f3);
        Reservation r4 = new Reservation(165, "Marseille Provence", "Otopeni", 4, false, f4);
        Reservation r5 = new Reservation(35, "Copenhagen Airport", "Marseille Provence", 5, false, f5);

        reservations.add(r1);
        reservations.add(r2);
        reservations.add(r3);
        reservations.add(r4);
        reservations.add(r5);

        boolean stop = false;
        String response;
        int option;
        do{
            System.out.println("Choose between admin and client: \n1. Admin\n2. Client \n3. Quit");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> connectAdmin();
                case 2 -> connectClient();
                case 3 -> stop = true;
                default -> System.out.println("Invalid option");
            }
            if(stop) return;
            System.out.println("Do you want to continue?");
            response = scanner.nextLine();
            if(!response.toLowerCase().equals("yes"))
                stop = true;
        }while(!stop);
    }

    /**
     * Method used to connect a client
     */
    public static void connectClient()
    {
        String choice;
        System.out.println("Please enter connecting information: ");
        System.out.println("1. Create new client");
        System.out.println("2. Client already exists");

        choice = scanner.nextLine();

        switch(choice)
        {
            case "1":
                createClient();
                break;
            case "2":
                existingClient();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    /**
     * Method used to create a new client
     */
    public static void createClient() {
        String nom;
        String prenom;
        String adresse;
        String telephone;

        System.out.println("Please enter your surname: ");
        nom = scanner.nextLine();
        System.out.println("Please enter your first name: ");
        prenom = scanner.nextLine();

        System.out.println("Please enter your address: ");
        adresse = scanner.nextLine();

        System.out.println("Please enter your phone number: ");
        //try - catch
        try {
            telephone = scanner.nextLine();
            if (clients.containsKey(telephone)) {
                throw new MyException("A client with this phone number already exists");
            }
            Client c = new Client(nom, prenom, adresse, telephone);
            clients.put(telephone, c);
            System.out.println("Your date has been registered");
            menuClient(c);
        } catch (MyException E) {
            System.out.println(E.getMessage());
        }

    }

    /**
     * Method used to connect an existing client
     */
    public static void existingClient()
    {
        String phoneNumber;
        System.out.println("Please enter your phone number");
        phoneNumber = scanner.nextLine();

        try{
            if(!clients.containsKey(phoneNumber))
                throw new MyException("Your phone number is not registered");

            System.out.println("You have logged in successfully");
            menuClient(clients.get(phoneNumber));

        }catch(MyException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Please register to continue");
            createClient();
        }

    }

    /**
     * Method used to connect the admin
     */
    public static void connectAdmin()
    {
        int choice;
        System.out.println("Please enter the id of the admin: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        if(choice != admin.getIdConnection())
        {
            System.out.println("Invalid identifier");
            return;
        }

        menuAdmin();

    }

    /**
     * This method represents the options of the menu for the admin
     */
    public static void menuAdmin()
    {
        String choiceAdmin;
        System.out.println("You are now the admin");
        System.out.println("------ADMIN MENU------");

        boolean contChoice = true;
        do{
            System.out.println("Please enter your option");
            System.out.println("1. See all available reservations");
            System.out.println("2. Create a reservation");
            System.out.println("3. Delete a reservation");
            System.out.println("4. See all available flights");
            System.out.println("5. Create a flight");
            System.out.println("6. Delete a flight");
            System.out.println("7. See all available planes");
            System.out.println("8. Create a plane");
            System.out.println("9. Delete a plane");
            System.out.println("10. See all available airports");
            System.out.println("11. Create an airport");
            System.out.println("12. Delete an airport");
            System.out.println("13. Apply discount");
            System.out.println("14. Quit");
            choiceAdmin = scanner.nextLine();

            switch (choiceAdmin)
            {
                case "1":{
                    Iterator<Reservation> res = reservations.iterator();
                    while (res.hasNext()) {
                        System.out.println(res.next().toString());
                    }
                }
                    break;
                case "2": {
                    admin.addReservation(reservations);
                }
                    break;
                case "3": {
                    admin.deleteReservation(reservations);
                }
                    break;
                case "4": {
                    Iterator<Flight> fl = flights.iterator();
                    while (fl.hasNext()) {
                        System.out.println(fl.next().toString());
                    }
                }
                    break;
                case "5": {
                    admin.addFlight(flights);
                }
                    break;
                case "6": {
                    admin.deleteFlight(flights);
                }
                    break;
                case "7": {
                    Iterator<Aeronef> pl = planes.iterator();
                    while (pl.hasNext()) {
                        System.out.println(pl.next().toString());
                    }
                }
                    break;
                case "8": {
                    admin.addAeronef(planes);
                }
                    break;
                case "9": {
                    admin.deleteAeronef(planes);
                }
                    break;
                case "10": {
                    Iterator<Airport> air = airports.iterator();
                    while (air.hasNext()) {
                        System.out.println(air.next().toString());
                    }
                }
                    break;
                case "11": {
                    admin.addAirport(airports);
                }
                    break;
                case "12": {
                    admin.deleteAirport(airports);
                }
                    break;
                case "13":
                {
                    System.out.println("Please choose the reservation you are willing to apply discount to: ");
                    for(int i = 0; i < reservations.size(); ++i)
                    {
                        System.out.println(i + ". " + reservations.get(i).toString());
                    }
                    int choice = scanner.nextInt();
                    System.out.println("Enter discount: ");
                    int discount = scanner.nextInt();
                    scanner.nextLine();
                    reservations.get(choice).applyDiscount(discount);
                    System.out.println("Discount applied");
                }
                break;
                case "14":
                {
                    contChoice = false;
                }
                break;
                default:
                    System.out.println("Invalid option");
            }
        }while(contChoice);
    }

    /**
     * This method represents the options for the menu of the client
     * @param c - the client of the application
     */
    public static void menuClient(Client c)
    {
        String choiceClient;
        System.out.println("------CLIENT MENU------");

        boolean contChoice = true;
        do {
            System.out.println("Please enter your option");
            System.out.println("1. See your current reservations");
            System.out.println("2. See all available reservations");
            System.out.println("3. Make a reservation");
            System.out.println("4. Get rid of expired reservations");
            System.out.println("5. Delete a reservation");
            System.out.println("6. See your reservations in sorted order");
            System.out.println("7. See all available reservations in sorted order");
            System.out.println("8. Quit");
            choiceClient = scanner.nextLine();
            switch (choiceClient) {
                case "1":
                    c.seeReservations();
                    break;
                case "2": {
                    Iterator<Reservation> res = reservations.iterator();
                    while (res.hasNext()) {
                        System.out.println(res.next().toString());
                    }
                }
                break;
                case "3": {
                    System.out.println("Please choose the reservation you are willing to add:");
                    for(int i = 0; i < reservations.size(); ++i)
                    {
                        System.out.println(i + ". " + reservations.get(i).toString());
                    }
                    int option = scanner.nextInt();
                    scanner.nextLine();
                    if(option > reservations.size())
                    {
                        System.out.println("Invalid index");
                        break;
                    }
                    c.addReservation(reservations.get(option));
                    reservations.remove(option);
                    System.out.println("The reservation has been added");
                }
                break;
                case "4": {
                    try {
                        c.deleteExpiredReservations();
                        System.out.println("Expired reservations have been deleted");
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case "5": {
                    System.out.println("Please choose a reservation to delete:");
                    c.seeReservations();
                    int reservationIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (reservationIndex >= c.getReservations().size()) {
                        System.out.println("Invalid index");
                        break;
                    }
                    c.deleteReservation(c.getReservations().get(reservationIndex));
                }
                break;
                case "6":
                {
                    c.sortReservations();
                    c.seeReservations();
                }
                break;
                case "7":
                    {
                        SortingAlgos<Reservation> sortingReservations = new SortingAlgos<>();
                        sortingReservations.mergeSort(reservations, 0, reservations.size() - 1);
                        Iterator<Reservation> res = reservations.iterator();
                        while (res.hasNext()) {
                            System.out.println(res.next().toString());
                        }

                    }
                break;
                case "8":
                    {
                        contChoice = false;
                    }
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }while(contChoice);


    }

}