package dvi.lpa;
import java.util.*;

import static java.io.ObjectInputFilter.merge;
import static java.util.Collections.sort;

public class MergeSort<T extends Comparable<T>> {

    public void mergeSort(T[] array) {
        T[] aux = Arrays.copyOf(array, array.length);
        sort(array, aux, 0, array.length -1);
    }

    private void sort(T[] array, T[] aux, int low, int high){
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;   //Calculate mid to prevent potential ovrflow
        sort(array, aux, low, mid);
        sort(array, aux, mid + 1, high);

        merge(array, aux, low, mid, high);
    }

    private void merge(T[] array, T[] aux, int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        //Copy elements from original array to auxilary array for merging
        System.arraycopy(array, low, aux, low, high - low + 1);

        for (int k = low; k <= high; k++){
            if ( i > mid) { //Left half exhausted
                array[k] = aux[j++];
            } else if (j > high) { //Right half exhausted
                array[k] = aux[i++];
            } else if (((Comparable<T>) aux[j]).compareTo(aux[i]) < 0) {    //Compare elements
                array[k] = aux[j++];
            } else{
                array[k] = aux[i++];
            }
        }
    }
}
