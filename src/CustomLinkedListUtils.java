public class CustomLinkedListUtils {
    private class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    public CustomLinkedListUtils() {
        head = null;
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
    }

    public void reverse(){
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void firstToLast(){
        Node current = head;
        Node temp = head;
        while(current.next != null){
            current = current.next;
        }
        head = head.next;
        current.next = temp;
        temp.next = null;
    }

    public void concatenate(CustomLinkedListUtils list){
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = list.head;
    }

    public int maxLength(){
        Node current = head;
        int max = 0;
        while(current != null){
            if(current.value.length() > max){
                max = current.value.length();
            }
            current = current.next;
        }
        return max;
    }

    public void lastToFirst(){
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node prev = null;
        while(current.next != null){
            prev = current;
            current = current.next;
        }
        prev.next = null;
        current.next = head;
        head = current;
    }

    public static void main(String[] args) {
        CustomLinkedListUtils list = new CustomLinkedListUtils();
        list.add("Hello");
        list.add("World");
        list.add("!!!");
        list.print(); // List elements: Hello World !!!
        System.out.println(list.maxLength()); // 5
        list.reverse();
        list.print(); // List elements: !!! World Hello
        list.firstToLast();
        list.print(); // List elements: World Hello !!!
        CustomLinkedListUtils list2 = new CustomLinkedListUtils();
        list2.add("Java");
        list2.add("is");
        list2.add("fun");
        list2.print(); // List elements: Java is fun
        list.concatenate(list2);
        list.print(); // List elements: World Hello !!! Java is fun
        list.lastToFirst();
        list.print(); // List elements: fun World Hello !!! Java is
    }
}
