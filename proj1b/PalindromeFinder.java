/**
 * This class outputs all palindromes in the words file in the current directory.
 */
package proj1b;

import edu.princeton.cs.introcs.In;

public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("/Users/xy/Desktop/UCB CS61B/code/library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
    }
}
