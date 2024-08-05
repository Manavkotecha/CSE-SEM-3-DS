
//-*+4325 = 9
import java.util.Scanner;
import java.util.Stack;

public class EvaluationOfPrefix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        System.out.println("Enter Infix expression");
        String s = sc.nextLine();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                st.push((ch - '0'));
            } else {
                int oprator1 = st.pop();
                int oprator2 = st.pop();

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
        System.out.println("Result = " + st.pop());
        sc.close();
    }
}
