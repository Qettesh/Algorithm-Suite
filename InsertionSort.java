package dvi.lpa;

public class InsertionSort {

    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int partIndex = 1; partIndex < array.length; partIndex++) {
            T curUnsorted = array[partIndex];
            int i = partIndex;

            while (i > 0 && array[i - 1].compareTo(curUnsorted) <= 0) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = curUnsorted;
        }
    }

    //Not needed for insertion sort, but included for completeness
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
