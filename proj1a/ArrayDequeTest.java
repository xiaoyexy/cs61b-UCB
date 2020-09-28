// package proj1a;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test
    public void testAdd() {
        ArrayDeque<Integer> res = new ArrayDeque<>();
        res.addFirst(3);
        res.printDeque();
        assertEquals(1, res.size());

        res.addFirst(5);
        res.printDeque();
        assertEquals(2, res.size());

        res.addLast(5);
        res.printDeque();
        assertEquals(3, res.size());

        res.addLast(5);
        res.printDeque();
        assertEquals(4, res.size());

        res.addLast(5);
        res.printDeque();
        assertEquals(5, res.size());

        res.addLast(5);
        res.printDeque();
        assertEquals(6, res.size());

        res.addLast(3);
        res.printDeque();
        assertEquals(7, res.size());

        res.addLast(7);
        res.printDeque();
        assertEquals(8, res.size());

        res.addFirst(8);
        res.printDeque();
        assertEquals(9, res.size());
    }

    @Test
    public void testRemove() {
        ArrayDeque<Integer> res = new ArrayDeque<>();
        res.addFirst(1);
        res.addFirst(2);
        res.addFirst(3);
        res.printDeque();

        res.removeFirst();
        res.printDeque();
        assertEquals(2, res.size());

        res.removeLast();
        res.printDeque();
        assertEquals(1, res.size());

        res.removeLast();
        res.printDeque();
        assertEquals(0, res.size());
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> res = new ArrayDeque<>();
        res.addFirst(1);
        res.addFirst(2);
        res.addFirst(3);
        res.printDeque();

        System.out.println(res.get(2));
        System.out.println(res.get(3));

    }

    @Test
    public void test1() {
        ArrayDeque<Integer> res = new ArrayDeque<>();
        res.addLast(0);
        res.removeFirst();
        res.addFirst(2);
        res.get(0);

        res.addFirst(4);
        res.addLast(5);
        res.addFirst(6);
        res.printDeque();

        res.removeFirst();
        res.removeFirst();

        res.printDeque();

        res.addLast(9);
        res.printDeque();

        res.removeLast();
        res.printDeque();

    }


}
