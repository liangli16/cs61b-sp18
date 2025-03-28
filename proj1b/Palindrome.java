public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> out = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            out.addLast(word.charAt(i));
        }
        return out;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }

        int last = word.length() - 1;
        int halfindex;
        //Even number of chars
        if (word.length() % 2 == 0) {
            halfindex = word.length() / 2;
        }
        //Odd number of chars
        else {
            halfindex = (word.length() - 1) / 2;
        }
        for (int i = 0; i < halfindex; i++) {
            if (word.charAt(i) == word.charAt(last - i)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }

        int last = word.length() - 1;
        int halfindex;
        //Even number of chars
        if (word.length() % 2 == 0) {
            halfindex = word.length() / 2;
        }
        //Odd number of chars
        else {
            halfindex = (word.length() - 1) / 2;
        }
        for (int i = 0; i < halfindex; i++) {
            if (cc.equalChars(word.charAt(i), word.charAt(last - i))) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}

