import java.util.Objects;

public class Reservation implements Comparable<Reservation> {
    private int price;
    private String departure;
    private String arrival;
    private int id;
    private boolean isFull;
    private Flight flight;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

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
