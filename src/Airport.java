import java.util.Objects;

public class Airport {

    String name;
    String city;

    public Airport(String name, String city)
    {
        this.name = name;
        this.city = city;
    }

    public Airport(Airport other)
    {
        this.copy(other);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void copy(Airport other)
    {
        this.setCity(other.getCity());
        this.setName(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport aeroport = (Airport) o;
        return Objects.equals(name, aeroport.name) && Objects.equals(city, aeroport.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }
}
