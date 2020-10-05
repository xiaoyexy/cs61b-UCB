// package proj1b;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void TestIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("aaab"));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertFalse(palindrome.isPalindrome("ACDC"));
        assertFalse(palindrome.isPalindrome("yang"));

        assertTrue(palindrome.isPalindrome("AAAaAAA"));
        assertTrue(palindrome.isPalindrome("ABBA"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("s"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
    }


    @Test
    public void testIsPalindromeCC() {
        OffByOne offByOne = new OffByOne();
        assertFalse(palindrome.isPalindrome("cat", offByOne));
        assertFalse(palindrome.isPalindrome("aaab", offByOne));
        assertFalse(palindrome.isPalindrome("Aa", offByOne));
        assertFalse(palindrome.isPalindrome("ACDC", offByOne));
        assertFalse(palindrome.isPalindrome("yang", offByOne));

        assertTrue(palindrome.isPalindrome("AAAaAAA", offByOne));
        assertTrue(palindrome.isPalindrome("ABBA", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("s", offByOne));
        assertTrue(palindrome.isPalindrome("racecar", offByOne));
        assertTrue(palindrome.isPalindrome("noon", offByOne));
    }
}
