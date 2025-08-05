package dvi.lpa;

public class FuzzyNode<T> {
    public T value;
    public FuzzyNode<T> next;

    public FuzzyNode(T value, FuzzyNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public FuzzyNode<T> getNext() {
        return next;
    }

    public void setNext(FuzzyNode<T> next) {
        this.next = next;
    }
}
