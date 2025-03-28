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
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testisPlaindrome() {
        String word = "racecar";
        Deque d = palindrome.wordToDeque(word);
        Boolean actual = palindrome.isPalindrome(word);
        assertTrue("racecar is palindrome", actual);
    }

    @Test
    public void testisPlaindrome2() {
        String word = "abcddcba";
        Deque d = palindrome.wordToDeque(word);
        Boolean actual = palindrome.isPalindrome(word);
        assertTrue("abcddcba is palindrome", actual);
    }

    @Test
    public void testisPlaindrome3() {
        String word = "";
        Deque d = palindrome.wordToDeque(word);
        Boolean actual = palindrome.isPalindrome(word);
        assertTrue(" is palindrome", actual);
        }

    @Test
    public void testisPlaindrome4() {
        String word = "m";
        Deque d = palindrome.wordToDeque(word);
        Boolean actual = palindrome.isPalindrome(word);
        assertTrue("m is palindrome", actual);
    }

    @Test
    public void testisPlaindrome5() {
        String word = "horse";
        Deque d = palindrome.wordToDeque(word);
        Boolean actual = palindrome.isPalindrome(word);
        assertFalse("horse is not palindrome", actual);
    }
}
