import java.util.Objects;

/**
 * This class represents a reservation in the application
 */
public class Reservation implements Comparable<Reservation> {
    private int price;
    private String departure;
    private String arrival;
    private int id;
    private boolean isFull;
    private Flight flight;

    /**
     * Constructor of the reservation class
     * @param price - the price of the reservation - must be greater than 0
     * @param departure - the departure city
     * @param arrival - the arrival city
     * @param id - the id of the reservation
     * @param isFull - boolean showing if there are places left for this reservation - true if the capacity of the plane is equal to the number of occupied seats for the flight attribute
     * @param flight - flight of the reservation
     */
    public Reservation(int price, String departure, String arrival, int id, boolean isFull, Flight flight) {
        try {
            if (flight.getNbPlacesOccupees() >= flight.getAvion().getCapacity())
                throw new MyException("The plane is already full, can not make reservation");

            this.price = price;
            this.departure = departure;
            this.arrival = arrival;
            this.id = id;
            if(flight.getNbPlacesOccupees() == flight.getAvion().getCapacity() - 1)
                this.isFull = true;
            else
                this.isFull = isFull;
            flight.setNbPlacesOccupees(flight.getNbPlacesOccupees() + 1);
            this.flight = new Flight(flight);
        }catch(MyException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @return the price of the reservation
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the reservation
     * @param price - price of the reservation
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return the departure city of the reservation
     */
    public String getDeparture() {
        return departure;
    }

    /**
     *
     * @param departure - the departure city of the reservation
     */

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /**
     *
     * @return the arrival city of the reservation
     */
    public String getArrival() {
        return arrival;
    }

    /**
     *
     * @param arrival the arrival city of the reservation
     */
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    /**
     *
     * @return the id of the reservation
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id the id of the reservation
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return boolean showing if there are places left for this reservation
     */
    public boolean isFull() {
        return isFull;
    }

    /**
     *
     * @param full - shows if there are places left for this reservation
     */
    public void setFull(boolean full) {
        isFull = full;
    }

    /**
     *
     * @return the flight of this reservation
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     *
     * @param flight the flight of this reservation
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * Method used to apply discount to the price of the reservation
     * @param discount - the discount applied to the price of the reservation - has to be smaller than the actual price of the reservation
     */
    public void applyDiscount(int discount)
    {
        try{
                if(this.getPrice() < discount)
                    throw new MyException("Discount bigger than actual price");
                else {
                    this.setPrice(this.getPrice() - discount);
                    System.out.println("The new price is: " + this.getPrice());
                }
        }catch (MyException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return price == that.price && id == that.id && isFull == that.isFull && departure.equals(that.departure) && arrival.equals(that.arrival) && flight.equals(that.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, departure, arrival, id, isFull, flight);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "price=" + price +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", id=" + id +
                ", isFull=" + isFull +
                ", flight=" + flight +
                '}';
    }

    @Override
    public int compareTo(Reservation other) {
        Integer firstPrice = this.price;
        Integer secondPrice = other.price;

        int ReservationComparison = firstPrice.compareTo(secondPrice);

        if(ReservationComparison != 0)
            return ReservationComparison;
        else{
            if(!this.isFull || other.isFull) return 1;
            else return -1;
        }
    }
}
