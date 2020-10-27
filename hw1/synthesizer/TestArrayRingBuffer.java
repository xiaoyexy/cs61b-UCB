//package hw1.synthesizer;
package synthesizer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the ArrayRingBuffer class.
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(3);
        arb.enqueue(1);
        arb.enqueue(2);
        assertEquals(2, arb.fillCount());
        arb.enqueue(3);
        try {
            arb.enqueue(3);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void testDequeue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(5);
        arb.enqueue(2);
        arb.enqueue(4);
        assertEquals(5, arb.peek());
        arb.dequeue();
        assertEquals(2, arb.fillCount());
        arb.dequeue();
        arb.dequeue();
        try {
            arb.dequeue();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
