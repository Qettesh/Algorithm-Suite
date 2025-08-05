package dvi.lpa;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class QueueArray<T> implements Iterable<T> {
    private T[] queueArray;
    private int head;
    private int tail;

    //Gets the number of elements currently in the queue.
    public int getCount(){
        return tail - head;
    }

    public boolean isEmpty(){
        return getCount() == 0;
    }

    //Get the total capaticy of the underlying arrray.
    public int getCapacity(){
        return queueArray.length;
    }

    public QueueArray() {
        this(8); // Default capacity
    }

    public QueueArray(int capcity) {
        //Java requires explicit casting when creating generic arrays
        this.queueArray = (T[]) new Object[capcity];
        this.head = 0;
        this.tail = 0;
    }

    public Object enqueue(T item) {//Java requires explicit casting when creating generic arrays.
        //Resize the array if it's full.
        if (queueArray.length == tail){
            //Create a new larger array (e.g., 2 times the current capacity).
            T[] largerArray = (T[]) new Object[getCount() * 2];
            //Copy the elements to the new array.
            System.arraycopy(queueArray, 0, largerArray, 0, getCount());
            queueArray = largerArray;
            head = 0; // Reset head to 0 after copying
            tail = getCount();// Set tail to the new count.
        }
        return queueArray[tail++] = item;
    }

    //Removes and returns the item at the front of the queue.
    public void dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        //IF the queue becomes empty, reset head and tail.
        if(isEmpty()){
            head = 0;
            tail = 0;
        }
    }

    //Returns the item at the front of the queue withut removing it.
    public T peek(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }

        return queueArray[head];
    }

    @Override
    public Iterator<T> iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private int currentIndex = head;

        @Override
        public boolean hasNext() {
            return currentIndex < tail;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return queueArray[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported by this iterator");
        }
    }

}
