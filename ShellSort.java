package dvi.lpa;

import java.util.List;

import static java.util.Collections.swap;

public class ShellSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void shellSort(T[] array) {
        int gap = 1;
        while (gap < array.length/3)
            gap = 3 * gap + 1;
        while (gap >= 1) {
            for (int i = gap; i < array.length; i++){
                for (int j = i; j >= gap && array[j].compareTo(array[j -1]) < 0; j -= gap){
                    swap(array, j, j - gap);
                }
            }
            gap /= 3;
        }

    }

    private static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
