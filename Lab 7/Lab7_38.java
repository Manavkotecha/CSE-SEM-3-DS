
public class StackLab {

    public static int push(int s[], int top, int x) {
        if (top >= s.length - 1) {
            System.out.println("Stack Overflow");
            return top;
        } else {
            top += 1;
            s[top] = x;
            return top;
        }
    }

    public static int pop(int s[], int top) {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return top;
        } else {
            System.out.println("Popped element: " + s[top]);
            top -= 1;
            return top;
        }
    }

    public static void update(int s[], int top, int pos, int x) {
        if (pos <= top && pos >= 0) {
            s[pos] = x;
            System.out.println("Updated element at position " + pos + " to " + x);
        } else {
            System.out.println("Invalid position");
        }
    }

    public static void peep(int s[], int top, int pos) {
        if (pos <= top && pos >= 0) {
            System.out.println("Element at position " + pos + ": " + s[pos]);
        } else {
            System.out.println("Invalid position");
        }
    }

    public static void display(int s[], int top) {
        if (top < 0) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(s[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int s[] = new int[100];
        int top = -1;

        top = push(s, top, 10);
        top = push(s, top, 20);
        top = push(s, top, 30);
        top = push(s, top, 40);
        top = push(s, top, 50);

        display(s, top);

        top = pop(s, top);

        update(s, top, 1, 25);
        display(s, top);

        peep(s, top, 0);

    }
}
