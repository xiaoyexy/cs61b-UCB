package proj1a;

public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private static final double USAGE_FACTOR = 0.25;
    private static final int RFACTOR = 2;

    public ArrayDeque() {
        this.size = 0;
        this.nextFirst = 7;
        this.nextLast = 0;
        this.items = (T[]) new Object[8];
    }

    private int moveOne(int index) {
        return (index + 1) % items.length;
    }

    private int backOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int length) {
        T[] newItems = (T[]) new Object[length];

        int oldIndex = moveOne(nextFirst);
        for (int i = 0; i < size; i += 1) {
            newItems[i] = items[oldIndex];
            oldIndex = moveOne(oldIndex);
        }

        items = newItems;
        nextFirst = newItems.length - 1;
        nextLast = size;
    }

    //Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        if (nextLast == nextFirst) {
            resize(items.length * RFACTOR);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = backOne(nextFirst);
    }


    //Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        if (nextLast == nextFirst) {
            resize(items.length * RFACTOR);
        }
        items[nextLast] = item;
        size += 1;
        nextLast += moveOne(nextLast);
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public int size() {
        return size;
    }


    //Prints the items in the deque from first to last, separated by a space
    public void printDeque() {
        for (int i = moveOne(nextFirst); i != nextLast; i = moveOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        int oldFirst = moveOne(nextFirst);
        T removed = items[oldFirst];
        items[oldFirst] = null;
        size -= 1;
        nextFirst = oldFirst;

        double currentUsage = size / (double) items.length;
        if (items.length >= 16 && currentUsage < USAGE_FACTOR) {
            resize(items.length / 2);
        }
        return removed;
    }


    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        int oldLast = backOne(nextLast);
        T removed = items[oldLast];
        items[oldLast] = null;
        size -= 1;
        nextLast = oldLast;

        double currentUsage = size / (double) items.length;
        if (items.length >= 16 && currentUsage < USAGE_FACTOR) {
            resize(items.length / 2);
        }
        return removed;
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    //If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        int pointer = nextFirst;
        int i = 0;
        while (i <= index) {
            pointer = moveOne(pointer);
            i += 1;
        }
        return items[pointer];
    }


}
