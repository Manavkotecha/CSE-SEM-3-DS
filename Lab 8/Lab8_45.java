
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix");
        String infix = sc.nextLine();
        infix += ")";

        if (infix.length() == 0) {
            System.out.println("String is empty");
            return;
        }

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
        System.out.println(polish);
        sc.close();
    }

    public static int stack_precedence(char temp) {
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
                return 0;
            default:
                return 8;
        }
    }

    public static int input_precedence(char temp) {
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
