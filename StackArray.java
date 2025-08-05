package dvi.lpa;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackArray<T> implements Iterable<T> {
    private Object[] items;
    private int count;
    private static final int DEFAULT_CAPACITY = 40;

    public StackArray(){
        this(DEFAULT_CAPACITY);
    }


    public StackArray(int capacity){
        items = new Object[capacity];
        count = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int size(){
        return count;
    }
    public T peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        T item = (T) items[count - 1];
        return item;
    }


    public T pop(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T item = (T) items[--count];
        items[count] = null; //help with garbage collection
        return item;
    }
    public void push(T item) {
        if (count == items.length) {
            resize(4 * items.length);
        }
        items[count++] = item;
    }


    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        System.arraycopy(items, 0, temp, 0, count);
        items = temp;
    }

    @Override
    public Iterator<T> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T>{
        private int currentIndex = count - 1;

        @Override
        public boolean hasNext(){
            return currentIndex >= 0;
        }


        @Override
        public T next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return (T) items[currentIndex--];
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
