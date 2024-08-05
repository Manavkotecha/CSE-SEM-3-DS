
import java.util.Scanner;

class Stack_Reco {

    int top = -1;
    int size = 0;
    char[] stack;

    public Stack_Reco(int size) {
        this.size = size;
        stack = new char[size];
    }

    public void push(char ch) {
        if (top >= size - 1) {
            System.out.println("Stack_Reco Overflow");
            return;
        }
        top++;
        stack[top] = ch;
    }

    public char pop() {
        if (top < 0) {
            System.out.println("Stack_Reco Underflow");
            return 0;
        }
        top--;
        return stack[top + 1];
    }
}

public class Recognize {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.next().toLowerCase();

        int len = str.length() / 2;
        Stack_Reco stack = new Stack_Reco(len);
        int index = 0;
        while (index < len) {
            stack.push(str.charAt(index));
            index++;
        }
        index++;

        while (index < str.length()) {
            char ch = stack.pop();
            if (str.charAt(index) != ch) {
                System.out.println("Invalid String");
                return;
            }
            index++;
        }
        System.out.println("Valid String");
        sc.close();
    }
}
