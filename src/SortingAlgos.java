import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class SortingAlgos<T extends Comparable<T>> {


    public void quicksort(ArrayList<T> array, int startIndex, int endIndex)
    {
        if(startIndex < endIndex)
        {
            int pivotIndex = getMedOf3(array, startIndex,endIndex);
            T pivot = array.get(pivotIndex);

            T temp = array.get(endIndex);
            array.set(endIndex, array.get(pivotIndex));
            array.set(pivotIndex, temp);

            int leftPointer = partition(array, startIndex, endIndex, pivot);
            quicksort(array, startIndex, leftPointer - 1);
            quicksort(array, leftPointer + 1, endIndex);
        }
    }

    private int getMedOf3(ArrayList<T> array, int startIndex, int endIndex)
    {
        int mid = startIndex + (endIndex - startIndex) / 2;
        if(array.get(endIndex).compareTo(array.get(startIndex)) < 0)
            swap(array, startIndex, endIndex);

        if(array.get(mid).compareTo(array.get(startIndex)) < 0)
            swap(array, mid, endIndex);

        if(array.get(endIndex).compareTo(array.get(mid)) < 0)
            swap(array, endIndex, mid);

        return mid;
    }

    private void swap(ArrayList<T> array, int leftPoz, int rightPoz)
    {
        T temp = array.get(leftPoz);
        array.set(leftPoz, array.get(rightPoz));
        array.set(rightPoz, temp);
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


    public void mergeSort(ArrayList<T> array, int startIndex, int endIndex){
        if(startIndex < endIndex)
        {
            int mid = startIndex + (endIndex - startIndex) / 2;
            mergeSort(array, startIndex, mid);
            mergeSort(array, mid + 1, endIndex);

            merge(array, startIndex, mid, endIndex);
        }
    }

    private void merge(ArrayList<T> array, int startIndex, int mid, int endIndex) {
        ArrayList<T> leftArray = new ArrayList<>();
        ArrayList<T> rightArray = new ArrayList<>();

        for (int i = startIndex; i <= mid; ++i)
            leftArray.add(array.get(i));

        for (int i = mid + 1; i <= endIndex; ++i)
            rightArray.add(array.get(i));

        int leftIndex = 0;
        int rightIndex = 0;
        int currIndex = startIndex;

        while (leftIndex < leftArray.size() && rightIndex < rightArray.size()) {
            if (leftArray.get(leftIndex).compareTo(rightArray.get(rightIndex)) <= 0) {
                array.set(currIndex, leftArray.get(leftIndex));
                leftIndex++;
                currIndex++;
            } else {
                array.set(currIndex, rightArray.get(rightIndex));
                rightIndex++;
                currIndex++;
            }
        }

        while(leftIndex < leftArray.size())
        {
            array.set(currIndex, leftArray.get(leftIndex));
            leftIndex++;
            currIndex++;
        }

        while(rightIndex < rightArray.size())
        {
            array.set(currIndex, rightArray.get(rightIndex));
            rightIndex++;
            currIndex++;
        }
    }
}
