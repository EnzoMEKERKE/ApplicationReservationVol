
package Partie_vol;

import java.util.Objects;

public class Reservation {
    private int price;
    private String departure;
    private String arrival;
    private int id;
    private boolean isFull;
    private Vol flight;

    public Reservation(int price, String departure, String arrival, int id, boolean isFull, Vol flight) {
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.id = id;
        this.isFull = isFull;
        this.flight = flight;
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

    public Vol getFlight() {
        return flight;
    }

    public void setFlight(Vol flight) {
        this.flight = flight;
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
}
