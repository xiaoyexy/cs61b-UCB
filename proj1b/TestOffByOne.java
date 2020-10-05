// package proj1b;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testequalChars() {
        assertTrue(offByOne.equalChars('c','c'));
        assertTrue(offByOne.equalChars('2','2'));
        assertFalse(offByOne.equalChars('c','d'));
        assertFalse(offByOne.equalChars('2','3'));

    }
}
