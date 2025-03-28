import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static Palindrome palindrome = new Palindrome();

    // Your tests go here.
    @Test
    public void testoffByOne1() {
        char x = 'a';
        char y = 'b';
        Boolean actual = offByOne.equalChars(x, y);
        assertTrue("a and b are off by one", actual);
    }

    @Test
    public void testoffByOne2() {
        char x = 'm';
        char y = 'z';
        Boolean actual = offByOne.equalChars(x, y);
        assertFalse("m and z are not off by one", actual);
    }

    @Test
    public void testoffByOne3() {
        char x = 'B';
        char y = 'A';
        Boolean actual = offByOne.equalChars(x, y);
        assertTrue("B and A are off by one", actual);
    }

    @Test
    public void testoffByOne4() {
        char x = '%';
        char y = '&';
        Boolean actual = offByOne.equalChars(x, y);
        assertTrue("% and & are off by one", actual);
    }

    @Test
    public void testisPlaindrome1() {
        String word = "flake";
        Deque d = palindrome.wordToDeque(word);
        Boolean actual = palindrome.isPalindrome(word, offByOne);
        assertTrue("falke is an offbyone palindrome", actual);
    }

    @Test
    public void testisPlaindrome2() {
        String word = "AyuxvxB";
        Deque d = palindrome.wordToDeque(word);
        Boolean actual = palindrome.isPalindrome(word, offByOne);
        assertTrue("AyuxvxB is an offbyone palindrome", actual);
    }

    @Test
    public void testisPlaindrome3() {
        String word = "Aasdf";
        Deque d = palindrome.wordToDeque(word);
        Boolean actual = palindrome.isPalindrome(word, offByOne);
        assertFalse("Aasdf is not an offbyone palindrome", actual);
    }

    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
}
