/**
 * This class represents a pilot of a plane
 */
public class Pilot {
    String name;
    int age;

    /**
     * Constructor of the pilot class
     * @param name - the name of the pilot
     * @param age - the age of the pilot
     */
    public Pilot(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Copy constructor of the pilot class
     * @param other - another object of type Pilot
     */
    public Pilot(Pilot other)
    {
        this.copy(other);
    }

    /**
     *
     * @return - the name of the pilot
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * Sets the name of the pilot
     * @param name - name of the pilot
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the age of the pilot - must be an integer greater than 0
     * @param age - the age of the pilot
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return the age of the pilot
     */
    public int getAge() {
        return age;
    }

    /**
     * Method used to copy the attributes from another object of type Pilot
     * @param other - another object of type Pilot
     */
    public void copy(Pilot other)
    {
        this.setAge(other.getAge());
        this.setName(other.getName());
    }

}
