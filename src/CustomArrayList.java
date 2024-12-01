public class CustomArrayList {

    private String[] array;
    private int size;

    public CustomArrayList(int capacity) {
        array = new String[capacity];
        size = 0;
    }

    public void print() {
        System.out.print("List elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public boolean contains(String element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void insert(int index, String element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size == array.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void add(String element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    public void set(int index, String element) {
        if (index >= 0 && index < size) {
            array[index] = element;
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;

    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList(2);
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
    }

    private void resize() {
        String[] newArray = new String[array.length * 2];
        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}