/**
 * An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */

package LectureCode.lists2;

public class SLList {

    // nested class never uses any instance variables or methods of the outer class, declare it static
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;


    /**
     * Creates a SLList.
     */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(int[] array) {
        sentinel = new IntNode(63, null);
        size = 0;
        IntNode p = sentinel;
        for (int num : array) {
            p.next = new IntNode(num, null);
            size += 1;
            p = p.next;
        }
    }


    /**
     * Adds x to the front of the list.
     */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /**
     * Returns the first item in the list.
     */
    public int getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds x to the end of the list.
     */
    public void addLast(int x) {
        size = size + 1;

        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /**
     * deletes the first element in your SLList.
     */
    public void deleteFirst() {

        IntNode p = sentinel;
        if (size >= 1) {
            sentinel.next = sentinel.next.next;
            size -= 1;
        } else {
            System.out.println("It'an Empty SLList, no first IntNode");
        }

    }

    /**
     * Returns the size of the list.
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L.size());

        SLList Q = new SLList(new int[]{2,3,4,5});
        System.out.println(Q.size());

    }
}