package dvi.lpa;

import java.util.List;
import java.util.Arrays;
import static java.util.Collections.swap;

public class QuickSort<T extends Comparable<T>> {
    public void quickSort(T[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(T[] array, int low, int high){
        if (high <= low) {
            return;
        }

        int j = partition(array, low, high);
        sort(array, low, j-1);
        sort(array, j+1, high);
    }

    private int partition(T[] array, int low, int high){
        int i = low;
        int j = high + 1;

        T pivot = array[low]; //Choosing the first element as pivot

        while (true){
            //Find item on left to swap
            while (array[++i].compareTo(pivot) < 0){
                if (i == high){
                    break;
                }
            }

            //Find item on right to swap
            while (pivot.compareTo(array[--j]) < 0){
                if (j == low)
                    break;
            }

            if (i >= j){
                break;
            }

            //Swap arrahy i and j.
            swap(array, i, j);
        }
        //Swap pivot into place
        swap(array, i, j);
        return j;
    }

    //private helper methods to swap elements in an  array
    private void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
