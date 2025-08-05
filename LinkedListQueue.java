package dvi.lpa;

import org.w3c.dom.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<T> implements Iterable<T>{

    //Node calss representing individual elements in the linked list
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private int count = 0;
    private Node<T> head;
    private Node<T> tail;

    public int getCount(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void enqueue(T item){
        Node<T> newNode = new Node<>(item);
        if (tail == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    public void dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        count--;
    }

    public T peek(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return head.value;
    }
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    //Inner class implementing the Iterator interface
    private class LinkedListIterator implements Iterator<T> {
        private LinkedListQueue.Node<T> current = head;

        @Override
        public boolean hasNext(){
            return current != null; //Check if there are more elements
        }

        @Override
        public T next(){
            if (!hasNext()){
                throw new NoSuchElementException(); //No more elements
            }
            T value = current.value;
            current = current.next; //Move to the next element
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

}


