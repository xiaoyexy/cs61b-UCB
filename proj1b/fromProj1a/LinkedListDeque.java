package proj1b.fromProj1a;

public class LinkedListDeque<T> {
    private Node<T> sentinel;
    private int size;

    private class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;

        Node(T item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }

    public LinkedListDeque() {
        this.sentinel = new Node(null);
        this.sentinel.prev = sentinel;
        this.sentinel.next = sentinel;
        this.size = 0;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        Node<T> temp = new Node(item);

        temp.next = sentinel.next;
        sentinel.next.prev = temp;
        sentinel.next = temp;
        temp.prev = sentinel;

        size += 1;
    }

    //Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        Node<T> temp = new Node(item);

        temp.prev = sentinel.prev;
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        temp.next = sentinel;

        size += 1;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //Prints the items in the deque from first to last, separated by a space
    public void printDeque() {
        Node<T> p;
        for (p = sentinel.next; p != sentinel; p = p.next) {
            System.out.print(p.item + " "); //pint不换行
        }
        System.out.println(); //println换行
    }

    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> removed = sentinel.next;
        sentinel.next = removed.next;
        removed.next.prev = sentinel;
        size -= 1;
        return removed.item;  //removed会被回收
    }


    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> removed = sentinel.prev;
        sentinel.prev = removed.prev;
        removed.prev.next = sentinel;
        size -= 1;
        return removed.item;  //removed会被回收
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    //If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (size < index + 1) {
            return null;
        }
        Node<T> p = sentinel;
        int i = 0;
        while (i <= index) {
            p = p.next;
            i += 1;
        }
        return p.item;
    }


    //Same as get, but uses recursion
    public T getRecursive(int index) {
        if (size < index + 1) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node<T> p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(p.next, index - 1);
    }

}
