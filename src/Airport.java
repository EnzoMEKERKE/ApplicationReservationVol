import java.util.Objects;

/**
 * This class represents an Aiport
 */
public class Airport {

    String name;
    String city;

    /**
     * The constructor of the Airport class
     * @param name - the name of the airport
     * @param city - the city of the airport
     */
    public Airport(String name, String city)
    {
        this.name = name;
        this.city = city;
    }

    /**
     * Copy constructor for the Airplane class
     * @param other - another object of type airport
     */
    public Airport(Airport other)
    {
        this.copy(other);
    }

    /**
     * Returns the name of the airport
     * @return name of the airport
     */
    public String getName() {
        return name;
    }

    /**
     * Sets current name of the airport
     * @param name - current name of the airport
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the city of the airport
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets current city of the airport
     * @param city of the airport
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method used to copy the attributes from another object of type airport
     * @param other - another object of type airport
     */
    public void copy(Airport other)
    {
        this.setCity(other.getCity());
        this.setName(other.getName());
    }

    /**
     * Method used to check of tho objects are equal
     * @param o - another object
     * @return boolean representing true if the objects are equal and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport aeroport = (Airport) o;
        return Objects.equals(name, aeroport.name) && Objects.equals(city, aeroport.city);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }
}
