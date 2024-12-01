import java.util.Arrays;

public class CustomLinkedListRecursion {
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

    public CustomLinkedListRecursion() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String get(int index) {
        return get(head, index);
    }

    private String get(Node current, int index) {
        if (current == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            return current.value;
        }
        return get(current.next, index - 1);
    }

    public void set(int index, String value) {
        set(head, index, value);
    }

    private void set(Node current, int index, String value) {
        if (current == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            current.value = value;
            return;
        }
        set(current.next, index - 1, value);
    }

    public void print() {
        System.out.print("List elements: ");
        print(head);
        System.out.println();
    }

    private void print(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.value + " ");
        print(current.next);
    }

    public int size() {
        return size;
    }

    public void add(String value) {
        head = add(head, value);
        size++;
    }

    private Node add(Node current, String value) {
        if (current == null) {
            return new Node(value);
        }
        current.next = add(current.next, value);
        return current;
    }

    public void insert(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        head = insert(head, index, value);
        size++;
    }

    private Node insert(Node current, int index, String value) {
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = current;
            return newNode;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        current.next = insert(current.next, index - 1, value);
        return current;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        head = remove(head, index);
        size--;
    }

    private Node remove(Node current, int index) {
        if (index == 0) {
            return current.next;
        }
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        current.next = remove(current.next, index - 1);
        return current;
    }

    public boolean contains(String value) {
        return contains(head, value);
    }

    private boolean contains(Node current, String value) {
        if (current == null) {
            return false;
        }
        if (current.value.equals(value)) {
            return true;
        }
        return contains(current.next, value);
    }

    public String[] toArray() {
        String[] array = new String[size];
        toArray(head, array, 0);
        return array;
    }

    private void toArray(Node current, String[] array, int index) {
        if (current == null) return;
        array[index] = current.value;
        toArray(current.next, array, index + 1);
    }

    public static void main(String[] args) {
        CustomLinkedListRecursion list = new CustomLinkedListRecursion();
        list.add("Hello");
        list.add("World");
        list.add("!!!");
        list.print(); // List elements: Hello World !!!
        System.out.println("Size: " + list.size()); // Size: 3
        System.out.println("Is list empty: " + list.isEmpty()); // Is list empty: false
        System.out.println("Element at index 1: " + list.get(1)); // Element at index 1: World
        System.out.println("Set element at index 1 to 'Java'");
        list.set(1, "Java");
        list.print(); // List elements: Hello Java !!!
        System.out.println("Remove item at index 0");
        list.remove(0);
        list.print(); // List elements: Java !!!
        System.out.println("Contains 'Java': " + list.contains("Java")); // Contains 'Java': true
        System.out.println("Contains 'Hello': " + list.contains("Hello")); // Contains 'Hello': false
        list.insert(0, "Hello");
        list.print(); // List elements: Hello Java !!!
        String[] array = list.toArray();
        System.out.println("Array: " + Arrays.toString(array)); // Array: [Hello, Java, !!!]
    }
}
