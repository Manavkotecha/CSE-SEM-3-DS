//546+*493/+* =350

import java.util.Scanner;
import java.util.Stack;

public class EvaluationOfPostfix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        System.out.println("Enter postfix expression:");
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                st.push(ch - '0');
            } else {
                int oprator2 = st.pop();
                int oprator1 = st.pop();

                switch (ch) {
                    case '+':
                        st.push(oprator1 + oprator2);
                        break;
                    case '-':
                        st.push(oprator1 - oprator2);
                        break;
                    case '*':
                        st.push(oprator1 * oprator2);
                        break;
                    case '/':
                        st.push(oprator1 / oprator2);
                        break;
                    default:
                        System.out.println("Invalid character is there: " + ch);
                        return;
                }
            }
        }
        System.out.println("Result: " + st.pop());
    }

}
