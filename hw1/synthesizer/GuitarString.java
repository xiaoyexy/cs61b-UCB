//package hw1.synthesizer;
package synthesizer;

//Make sure this class is public
public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor
    private BoundedQueue<Double> buffer;      //   Buffer for storing sound data. */

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        //   Your buffer should be initially filled with zeros.

        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<Double>(capacity);
        for (int i = 0; i < capacity - 1; i++) {
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //  Make sure that your random numbers are different from each other.
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }

        while (!buffer.isFull()) {
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        Double first = buffer.dequeue();
        Double second = buffer.peek();
        buffer.enqueue(DECAY * (first + second) * 0.5);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
