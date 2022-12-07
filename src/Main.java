public class Main {
    public static void main(String[] args) {
       Director director = new Director();

       AeronefBuilder builder = new AeronefBuilder();
       director.constructDR400(builder);

       Aeronef aeronef =  builder.getResult();

        System.out.println(aeronef.getType());
    }
}