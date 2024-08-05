
import java.util.Scanner;

class LinkedListClass {

    Node first;

    class Node {

        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            return;
        }
        newNode.link = first;
        first = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            return;
        }
        Node currentNode = first;
        while (currentNode.link != null) {
            currentNode = currentNode.link;
        }
        currentNode.link = newNode;
    }

    public void print() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node currentNode = first;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.link;
        }
        System.out.println("NULL");
    }

    public void deleteFirst() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        first = first.link;
    }

    public void deleteLast() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        if (first.link == null) {
            first = null;
            return;
        }
        Node current = first;
        while (current.link.link != null) {
            current = current.link;
        }
        current.link = null;
    }

    public int search(int key) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.data == key) {
                return index;
            }
            current = current.link;
            index++;
        }
        return -1;
    }

    public void insertIndex(int index, int data) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(data);

        if (index == 0) {
            newNode.link = first;
            first = newNode;
            return;
        }

        Node temp = first;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null) {
                System.out.println("Index out of bounds");
                return;
            }
            temp = temp.link;
        }

        if (temp == null || temp.link == null && index > 0) {
            System.out.println("Index out of bounds");
            return;
        }

        newNode.link = temp.link;
        temp.link = newNode;
    }

    public void deleteIndex(int index) {
        Node current = first;

        for (int i = 1; i < index - 1; i++) {
            current = current.link;
        }
        current.link = current.link.link;
    }

    public void count() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node currentent = first;
        int count = 0;
        while (currentent != null) {
            currentent = currentent.link;
            count++;
        }
        System.out.println("Number of nodes = " + count);
    }

    public static void main(String[] args) {
        LinkedListClass list = new LinkedListClass();
        Scanner sc = new Scanner(System.in);
        int choice, value, position;

        do {
            System.out.println("Linked List Operations:");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete at Position");
            System.out.println("7. Print List");
            System.out.println("8. Search");
            System.out.println("9. Count Nodes");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add at first: ");
                    value = sc.nextInt();
                    list.addFirst(value);
                    break;
                case 2:
                    System.out.print("Enter value to add at last: ");
                    value = sc.nextInt();
                    list.addLast(value);
                    break;
                case 3:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    System.out.print("Enter position to insert: ");
                    position = sc.nextInt();
                    list.insertIndex(position, value);
                    break;
                case 4:
                    list.deleteFirst();
                    break;
                case 5:
                    list.deleteLast();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    position = sc.nextInt();
                    list.deleteIndex(position);
                    break;
                case 7:
                    list.print();
                    break;
                case 8:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    int index = list.search(value);
                    if (index != -1) {
                        System.out.println("Value found at index: " + (index + 1));
                    } else {
                        System.out.println("Value not found in the list.");
                    }
                    break;
                case 9:
                    list.count();
                    break;
                case 10:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 10);

        sc.close();
    }
}
