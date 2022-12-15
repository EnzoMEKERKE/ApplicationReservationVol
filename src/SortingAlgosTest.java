import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
class SortingAlgosTest {
    ArrayList<Integer>IntegerList;
    ArrayList<Integer>IntegerList2;
    SortingAlgos<Integer> IntegerSorting;

    @BeforeEach
    void setUp()
    {
        IntegerList = new ArrayList<>();
        IntegerList.add(2);
        IntegerList.add(4);
        IntegerList.add(1);
        IntegerList.add(0);
        IntegerList.add(10);
        IntegerList2 = new ArrayList<>(IntegerList);
        IntegerSorting = new SortingAlgos<>();
        Collections.sort(IntegerList2);
    }
    @Test
    void quicksort() {

        IntegerSorting.quicksort(IntegerList, 0, IntegerList.size() - 1);

        assertArrayEquals(IntegerList.toArray(), IntegerList2.toArray());

    }

    @Test
    void mergeSort() {
        IntegerSorting.mergeSort(IntegerList, 0, IntegerList.size() - 1);

        assertArrayEquals(IntegerList.toArray(), IntegerList2.toArray());

    }

}