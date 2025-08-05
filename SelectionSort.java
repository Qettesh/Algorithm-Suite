package dvi.lpa;

import java.util.List;

import static java.util.Collections.swap;

public class SelectionSort<T extends Comparable<T>> {
    //Class with genertic type T that implements Comparable
    public static  <T extends Comparable<T>> void selectionSort(T[] array) {
        int largestAt = 0;
        int partIndex;
        for (partIndex = array.length - 1; partIndex > 0; partIndex--) {
            largestAt = 0;

            for (int i = 1; i <= partIndex; i++) {
                //Use compareTo for comparison of generic types
                if (array[i].compareTo(array[largestAt]) > 0) {
                    largestAt = i;
                }
            }
            swap(array, largestAt, partIndex);
        }
    }

    private static <T> void swap(T[] array, int index1, int index2) {// Helper method to swap elements
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
