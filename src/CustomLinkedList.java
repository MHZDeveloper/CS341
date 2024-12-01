import java.util.Arrays;

public class CustomLinkedList {
    private class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String get(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.value;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }

    public void set(int index, String value) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.value = value;
                return;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }

    public void print() {
        Node current = head;
        System.out.print("List elements: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public void add(String value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
        size++;
    }

    public void insert(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            count++;
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            count++;
            current = current.next;
        }
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        current.next = current.next.next;
        size--;
    }

    public boolean contains(String value) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public String[] toArray() {
        String[] array = new String[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add("Hello");
        list.add("World");
        list.add("!!!");
        list.print(); // List elements: Hello World !!!
        System.out.println("Size: "+ list.size()); // Size: 3
        System.out.println("Is list empty: "+ list.isEmpty()); // Is list empty: false
        System.out.println("Element at index 1: "+ list.get(1)); // Element at index 1: Java
        System.out.println("Set element at index 1 to 'Java'");
        list.set(1, "Java");
        list.print(); // List elements: Hello Java !!!
        System.out.println("Remove item at index 0");
        list.remove(0);
        list.print(); // List elements: Java !!!
        System.out.println("Contains 'Java': "+ list.contains("Java")); // Contains 'Java': true
        System.out.println("Contains 'Hello': "+ list.contains("Hello")); // Contains 'Hello': false
        list.insert(0, "Hello");
        list.print(); // List elements: Hello Java !!!
        String[] array = list.toArray();
        System.out.println("Array: " + Arrays.toString(array)); // Array: [Hello, Java, !!!]
    }
}
