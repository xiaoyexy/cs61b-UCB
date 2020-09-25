package lab3.Flik;

import org.junit.Test;

import static org.junit.Assert.*;

public class HorribleSteve {
    @Test
    public void testSameNumber() {
        assertTrue(Flik.isSameNumber(125, 125));  //fail
    }

    public static void main(String[] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
