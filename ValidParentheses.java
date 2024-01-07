import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char parantheses : s.toCharArray()) {
            if (parantheses == '(' || parantheses == '{' || parantheses == '[') {
                stack.push(parantheses);
                continue;
            }
            if (stack.isEmpty() || !matches(stack.pop(), parantheses)) return false;
        }
        return stack.isEmpty();
    }

    private boolean matches(char opening, char closing) {
        return switch (opening) {
            case '(' -> closing == ')';
            case '{' -> closing == '}';
            case '[' -> closing == ']';
            default -> false;
        };
    }
}