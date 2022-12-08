import java.util.ArrayList;
import java.util.Random;

public class SortingAlgos<T extends Comparable<T>> {

    public void quicksort(ArrayList<T> array, int startIndex, int endIndex)
    {
        if(startIndex < endIndex)
        {
            int pivotIndex = new Random().nextInt(endIndex - startIndex) + startIndex;
            T pivot = array.get(pivotIndex);

            T temp = array.get(endIndex);
            array.set(endIndex, array.get(pivotIndex));
            array.set(pivotIndex, temp);

            int leftPointer = partition(array, startIndex, endIndex, pivot);
            quicksort(array, startIndex, leftPointer - 1);
            quicksort(array, leftPointer + 1, endIndex);
        }
    }

    private int partition(ArrayList<T> array, int startIndex, int endIndex, T pivot)
    {
        int leftPointer = startIndex;
        int rightPointer = endIndex - 1;

        while(leftPointer < rightPointer)
        {
            while(array.get(leftPointer).compareTo(pivot) <= 0 && leftPointer < rightPointer)
                    leftPointer++;

            while(array.get(rightPointer).compareTo(pivot) >= 0 && leftPointer < rightPointer)
                    rightPointer--;

            T temp = array.get(leftPointer);
            array.set(leftPointer, array.get(rightPointer));
            array.set(rightPointer, temp);
        }

        if(array.get(leftPointer).compareTo(array.get(endIndex)) > 0){
            T temp = array.get(leftPointer);
            array.set(leftPointer, array.get(endIndex));
            array.set(endIndex, temp);
        }
        else{
            leftPointer = endIndex;
        }
        return leftPointer;

    }
}
