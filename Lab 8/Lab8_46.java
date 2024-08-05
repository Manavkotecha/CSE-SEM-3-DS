
import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix");
        String str = sc.next();
        String infix = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(') {
                infix += ')';
            } else if (str.charAt(i) == ')') {
                infix += '(';
            } else {
                infix += str.charAt(i);
            }
        }
        infix += ")";

        Stack<Character> stack = new Stack<>();
        stack.push('(');
        String polish = "";
        int rank = 0;

        for (int i = 0; i < infix.length(); i++) {
            char next = infix.charAt(i);
            while (stack_precedence(stack.peek()) > input_precedence(next)) {
                char temp = stack.pop();
                polish += temp;
                rank += rank(temp);
                if (rank < 1) {
                    System.out.println("Invalid");
                    return;
                }
            }
            if (stack_precedence(stack.peek()) != input_precedence(next)) {
                stack.push(next);
            } else {
                stack.pop();
            }
        }

        if (!stack.isEmpty() || rank != 1) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");

        StringBuilder prefix = new StringBuilder();
        for (int i = polish.length() - 1; i >= 0; i--) {
            if (polish.charAt(i) == '(') {
                prefix.append(')');
            } else if (polish.charAt(i) == ')') {
                prefix.append('(');
            } else {
                prefix.append(polish.charAt(i));
            }
        }

        System.out.println(prefix.toString());
        sc.close();
    }

    public static int stack_precedence(char temp) {
        switch (temp) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 3;
            case '^':
                return 6;
            case '(':
                return 0;
            default:
                return 8;
        }
    }

    public static int input_precedence(char temp) {
        switch (temp) {
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 4;
            case '^':
                return 5;
            case '(':
                return 9;
            case ')':
                return 0;
            default:
                return 7;
        }
    }

    public static int rank(char temp) {
        switch (temp) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return -1;
            default:
                return 1;
        }
    }
}
