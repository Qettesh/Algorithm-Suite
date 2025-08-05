package dvi.lpa;

import java.util.*;
/**
 * A generic circular queue data structure.
 *
 * @param <T> the type of elements in the queue
 */
public class CircularQueue<T> implements Iterable<T> {
    private T[] circularQueue;
    private int head;
    private int tail;
    private int count; // Maintain a count explicitly for accurate size tracking

    /**
     * Constructs a circular queue with the default capacity.
     */
    public CircularQueue(){
        final int DEFAULT_CAPACITY = 8;
        circularQueue = (T[]) new Object [DEFAULT_CAPACITY]; //
        this.circularQueue = circularQueue;
        head = 0;
        tail = 0;
        count = 0;
    }

    /**
     * Constructs a circular queue with the specified capacity.
     *
     * @param capacity the initial capacity of the queue
     */
    public CircularQueue(int capacity){
        circularQueue = (T[]) new Object [capacity];
        head = 0;
        tail = 0;
        count = 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    public int getCount(){
        return count;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /**
     * Returns the capacity of the queue.
     *
     * @return the capacity of the queue
     */
    public int getCapacity(){
        return circularQueue.length;
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param item the element to add
     */
    public void enqueue(T item){
        // Unwrap the queue when it doubles in size
        if (count == circularQueue.length){
            T[] newArray = (T[]) new Object[2 * circularQueue.length];
            System.arraycopy(circularQueue, head, newArray, 0, circularQueue.length - head);//
            System.arraycopy(circularQueue, 0, newArray, circularQueue.length - head, tail); //

            circularQueue = newArray;
            head = 0;
            tail = count; //after unwrapping, tail is at the end of the new array
        }

        circularQueue[tail] = item;
        tail = (tail + 1) % circularQueue.length;
        count++;
    }

    /**
     * Removes an element from the front of the queue.
     *
     * @throws IllegalStateException if the queue is empty
     */
    public void dequeue(){
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty.");//
        }

        circularQueue[head] = null; //Set to null to allow garbage collection
        head = (head + 1) % circularQueue.length; //Handle circular increment
        count--;
        if (isEmpty()){head = tail = 0;}
    }


    public T peek(){
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty.");
        }
        return circularQueue[head];
    }

    @Override
    public Iterator<T> iterator(){
        return new CircularQueueIterator(circularQueue, head, count);
    }

    @Override
    public String toString() {
        return "dvi.lpa.CircularQueue{" +
                "circularQueue=" + Arrays.toString(circularQueue) +
                ", head=" + head +
                ", tail=" + tail +
                ", count=" + count +
                '}';
    }


}
