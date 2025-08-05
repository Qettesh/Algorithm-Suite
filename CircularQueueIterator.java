package dvi.lpa;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueueIterator<T> implements Iterator<T> {
    private final T[] circularQueue;
    private final int head;
    private final int count;
    private int currentIndex = 0;
    private int elementsVisited = 0;

    public CircularQueueIterator(T[] circularQueue, int head, int count){

        this.circularQueue = circularQueue;
        this.head = head;
        this.count = count;
    }

    @Override
    public boolean hasNext(){
        return elementsVisited < count;
    }

    @Override
    public T next(){
        if (!hasNext()){
            throw new NoSuchElementException();//
        }
        T element = circularQueue[(head + currentIndex) % circularQueue.length];
        currentIndex++;
        elementsVisited++;
        return element;
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException("Remove operation is not supported");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (CircularQueueIterator<T> it = this; it.hasNext(); ) {
            T element = it.next();
            sb.append(element).append(", ");

        }
        if (sb.length() > 1){
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
}
