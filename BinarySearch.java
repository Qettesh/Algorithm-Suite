package dvi.lpa;

import jdk.jshell.spi.ExecutionControl;

import java.util.NoSuchElementException;

public class BinarySearch<T extends Comparable<T>> implements Iterable<T> {

    //Recusrive binary search
    public static int BinarySearch(int[] array, int value){
        return recursiveBinarySearch(array, value, 0, array.length);
    }

    private static int recursiveBinarySearch(int[] array, int value, int low, int high){
        if (low >= high) return -1;
        int mid = (low + high) /2;
        if(array[mid] == value) return mid;
        if(array[mid] < value) return IntRecBInSearch(mid + 1, high);
        return IntRecBinSearch(low, mid);
    }

    private static int IntRecBinSearch(int low, int mid) {
        return Integer.parseInt(null);
    }

    private static int IntRecBInSearch(int i, int high) {
        return Integer.parseInt(null);
    }

    //Linear binary search
    public static int BinSearch(int[] array, int value){
        int low = 0;
        int high = array.length;
        while (low < high){
            int mid = (low + high) / 2;
            if (array[mid] == value)
                return mid;
            if (array[mid] < value) low = mid + 1;
            else high = mid;
        }
    return -1;
    }

    public java.util.Iterator<T> iterator(){
        //FOr demonstration, assume we have a collection of T
        //In a real scenario, this will be implemented based on the actual data structure
        return new java.util.Iterator<T>() {
            @Override
            public boolean hasNext() {
                throw new NoSuchElementException();
            }

            @Override
            public T next() {
                if (!hasNext())
                throw new NoSuchElementException();
                try {
                    throw new ExecutionControl.NotImplementedException("next not implemented");
                } catch (ExecutionControl.NotImplementedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    //Custom exception for not implemnted methods
    private static class NotImplementedException extends RuntimeException{
        public NotImplementedException(String message){
            super(message);
        }
    }
}
