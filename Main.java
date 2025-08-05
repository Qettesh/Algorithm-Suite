package dvi.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] array = {5, 2, 8, 1, 9};
        mergeSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}

