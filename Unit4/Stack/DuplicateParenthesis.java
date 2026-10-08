package Unit4.Stack;

import java.util.Stack;

public class DuplicateParenthesis {
    public static void main(String[] args) {
        String str = "((a + b) + (c + d))";
        System.out.println(isDuplicate(str));
    }

    public static boolean isDuplicate(String exp) {
        Stack<Character> stack = new Stack<>();
        int n = exp.length();
        for (int i = 0; i < n; i++) {
            char curr = exp.charAt(i);

            if (curr != ')') {
                stack.push(curr);
                continue;
            } else {
                int count = 0;
                while (stack.peek() != '(') {
                    count++;
                    stack.pop();
                }
                if (count < 1) {
                    return true;
                }
                stack.pop();
            }
        }
        return false;
    }
}
