
public class CheckTwoList {

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public Node head;

    public void addLast(int data) {
        Node n2 = new Node(data);

        if (head == null) {
            head = n2;
            return;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n2;

        }
    }

    public static void check(CheckTwoList c1, CheckTwoList c2) {

        Node temp1 = c1.head;
        Node temp2 = c2.head;

        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data) {
                System.out.println("Both LinkedList are not equal");
                return;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1 == null && temp2 == null) {
            System.out.println("Both LinkedList are equal");
        } else {
            System.out.println("Both LinkedList are not equal");
        }
    }

    public static void main(String[] args) {
        CheckTwoList c1 = new CheckTwoList();
        CheckTwoList c2 = new CheckTwoList();

        c1.addLast(0);
        c1.addLast(1);
        c1.addLast(2);
        c1.addLast(3);
        c1.addLast(4);
        c1.addLast(5);

        c2.addLast(0);
        c2.addLast(1);
        c2.addLast(2);
        c2.addLast(3);
        c2.addLast(4);
        c2.addLast(5);

        check(c1, c2);
    }
}
