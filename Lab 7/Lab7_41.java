
import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to check for balanced parentheses:");
        String s = sc.nextLine();

        if (isBalanced(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if ((ch == ')' && temp != '(') || (ch == '}' && temp != '{') || (ch == ']' && temp != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
