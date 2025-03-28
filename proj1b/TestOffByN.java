import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    static CharacterComparator offBy3 = new OffByN(3);
    static CharacterComparator offBy5 = new OffByN(5);

    // Your tests go here.
    @Test
    public void testoffBy3() {
        char x = 'a';
        char y = 'd';
        Boolean actual = offBy3.equalChars(x, y);
        assertTrue("a and d are off by 3", actual);
    }


    @Test
    public void testoffBy5() {
        char x = 'o';
        char y = 't';
        Boolean actual = offBy5.equalChars(x, y);
        assertTrue("o and t are off by 5", actual);
    }

    @Test
    public void testoffBy5_2() {
        char x = 'x';
        char y = 't';
        Boolean actual = offBy5.equalChars(x, y);
        assertFalse("x and t are not off by 5", actual);
    }

}
