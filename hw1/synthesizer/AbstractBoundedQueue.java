package hw1.synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    public int capacity() {
        return capacity;
    }

    public int fillCount() {
        return fillCount;
    }

//    public boolean isEmpty()   //default method in BoundedQueue
//
//    public boolean isFull()    //default method in BoundedQueue
//
//    public abstract T peek();
//
//    public abstract T dequeue();
//
//    public abstract void enqueue(T x);
//
//    Iterator<T> iterator();

}
