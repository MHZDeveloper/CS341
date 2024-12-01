import java.util.Stack;

public class StackUtils {

    public static boolean areStacksEqual(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.size() != s2.size()) {
            return false;
        } else {
            Stack<Integer> s3 = new Stack<>();
            boolean same = true;
            while (!s1.isEmpty()) {
                int num1 = s1.pop();
                int num2 = s2.pop();
                if (num1 != num2) {
                    same = false;
                    break;
                }
                s3.push(num1);
                s3.push(num2);
            }

            while (!s3.isEmpty()) {
                s2.push(s3.pop());
                s1.push(s3.pop());
            }

            return same;
        }
    }

    public static boolean areBracketsBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (!isMatchingPair(last, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        System.out.println(areStacksEqual(s1, s2)); // true
        s1.pop();
        System.out.println(areStacksEqual(s1, s2)); // false
        s1.push(2);
        System.out.println(areStacksEqual(s1, s2)); // true

        System.out.println(areBracketsBalanced("()")); // true
        System.out.println(areBracketsBalanced("(){}[]")); // true
        System.out.println(areBracketsBalanced("([{}])")); // true
        System.out.println(areBracketsBalanced("([)]")); // false
        System.out.println(areBracketsBalanced("([)")); // false
    }
}
