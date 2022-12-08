import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer>Arr = new ArrayList<>();

        Arr.add(12);
        Arr.add(1);
        Arr.add(12);
        Arr.add(2000);
        Arr.add(5);
        Arr.add(120);
        Arr.add(12131);
        Arr.add(0);
        Arr.add(7);
        Arr.add(32);
        Arr.add(73);
        Arr.add(909);
        System.out.println(Arr);
        SortingAlgos<Integer> Sorter = new SortingAlgos<>();
        Sorter.quicksort(Arr, 0, Arr.size() - 1);
        System.out.println(Arr);

        ArrayList<Aeronef>ArrAeronef = new ArrayList<>();
       Director director = new Director();

       AeronefBuilder builder = new AeronefBuilder();
       director.constructDR400(builder);

       Aeronef aeronef1 =  builder.getResult();
       director.constructCESSNA152(builder);
       Aeronef aeronef2 = builder.getResult();
       director.constructCESSNA152(builder);
       Aeronef aeronef3 = builder.getResult();
       director.constructFOUGA_MAGISTER(builder);
       Aeronef aeronef4 = builder.getResult();
       director.constructPA28(builder);
       Aeronef aeronef5 = builder.getResult();
       ArrAeronef.add(aeronef4);
       ArrAeronef.add(aeronef2);
       ArrAeronef.add(aeronef3);
       ArrAeronef.add(aeronef5);
       ArrAeronef.add(aeronef1);
       Iterator<Aeronef> aeronefIterator = ArrAeronef.iterator();
        while(aeronefIterator.hasNext())
        {
            System.out.println(aeronefIterator.next().toString());
        }
        System.out.println("After sorting");
        SortingAlgos<Aeronef> aeronefSorter = new SortingAlgos<>();
        aeronefSorter.quicksort(ArrAeronef, 0, ArrAeronef.size() - 1);
        for(Aeronef aero : ArrAeronef)
        {
            System.out.println(aero.toString());
        }
        /*aeronefIterator = ArrAeronef.iterator();
        while(aeronefIterator.hasNext())
        {
            System.out.println(aeronefIterator.next().toString());
        }
        */
        //System.out.println(aeronef.compareTo(aeronef2));
        //System.out.println(aeronefSorter.partition());
        //System.out.println();
    }
}