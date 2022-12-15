import java.util.ArrayList;

/**
 * This class is used to define merge sort and quick sort algorithms for generic types
 * @param <T> - generic type that must extend Comparable
 */
public class SortingAlgos<T extends Comparable<T>> {

    /**
     * QuickSort method - sorts an ArrayList of generic types using QuickSort algorithm by choosing the pivot as the median of 3 (first, middle, last)
     * @param array - the list to be sorted
     * @param startIndex - the starting index
     * @param endIndex - the ending index
     */
    public void quickSort(ArrayList<T> array, int startIndex, int endIndex)
    {
        if(startIndex < endIndex)
        {
            int pivotIndex = getMedOf3(array, startIndex,endIndex);
            T pivot = array.get(pivotIndex);

            T temp = array.get(endIndex);
            array.set(endIndex, array.get(pivotIndex));
            array.set(pivotIndex, temp);

            int leftPointer = partition(array, startIndex, endIndex, pivot);
            quickSort(array, startIndex, leftPointer - 1);
            quickSort(array, leftPointer + 1, endIndex);
        }
    }

    /**
     * Method used to get the median of 3 elements and sort them is ascending order
     * @param array - the list to be sorted
     * @param startIndex - the starting index
     * @param endIndex - the ending index
     * @return the position of the pivot
     */
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

    /**
     * Method used to swap two elements in an ArrayList
     * @param array - the list of elements
     * @param leftPoz - the position of the first element
     * @param rightPoz - the position of the second element
     */
    private void swap(ArrayList<T> array, int leftPoz, int rightPoz)
    {
        T temp = array.get(leftPoz);
        array.set(leftPoz, array.get(rightPoz));
        array.set(rightPoz, temp);
    }

    /**
     * Method used to get the position of the pivot
     * @param array - the list to be sorted
     * @param startIndex - the starting index
     * @param endIndex - the ending index
     * @param pivot - the pivot
     * @return the position of the pivot when all the smaller elements are in its left and all the bigger elements are in its right
     */
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

    /**
     * MergeSort method - sorts an ArrayList of generic types using MergeSort algorithm
     * @param array - the list to be sorted
     * @param startIndex - the starting index
     * @param endIndex - the ending index
     */
    public void mergeSort(ArrayList<T> array, int startIndex, int endIndex){
        if(startIndex < endIndex)
        {
            int mid = startIndex + (endIndex - startIndex) / 2;
            mergeSort(array, startIndex, mid);
            mergeSort(array, mid + 1, endIndex);

            merge(array, startIndex, mid, endIndex);
        }
    }

    /**
     * Actual merge method
     * @param array - the list of elements to be sorted
     * @param startIndex - the starting index
     * @param mid - the middle element
     * @param endIndex - the ending index
     */
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
