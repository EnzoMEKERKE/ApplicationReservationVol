public class Pilot {
    String name;
    int age;

    public Pilot(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pilot(Pilot other)
    {
        this.copy(other);
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void copy(Pilot other)
    {
        this.setAge(other.getAge());
        this.setName(other.getName());
    }

}
