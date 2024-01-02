public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[\\W|_]", "");
        s = s.toLowerCase();
        int i = 0;
        int half = s.length() / 2;
        while (i < half && isPalindrome(s, i)) {
            i++;
        }
        return i == half || i == half + 1;
    }

    private boolean isPalindrome(String s, int i) {
        return s.charAt(i) == s.charAt(s.length() - i - 1);
    }
}
