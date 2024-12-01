import java.util.ArrayList;
import java.util.List;

public class QueueArrayList {

    private List<String> elements = new ArrayList<>();

    public void enqueue(String value) {
        elements.add(value);
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements.remove(0);
    }

    public String toString() {
        return "Queue [elements=" + elements + "]";
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements.get(0);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        QueueArrayList queue = new QueueArrayList();
        System.out.println("Is Queue Empty:"+queue.isEmpty()); // Is Queue Empty:true

        queue.enqueue("Roger");
        queue.enqueue("Rafael");
        queue.enqueue("Novak");

        System.out.println("Is Queue Empty:"+queue.isEmpty()); // Is Queue Empty:false

        System.out.println(queue); // Queue [elements=[Roger, Rafael, Novak]]

        System.out.println("Queue Size:"+queue.size()); // Queue Size:3

        System.out.println("Peek Top Element:"+queue.peek()); // Peek Top Element:Roger

        System.out.println("After peek:"+queue); // After peek:Queue [elements=[Roger, Rafael, Novak]]

        System.out.println("Dequeue Top Element:"+queue.dequeue()); // Dequeue Top Element:Roger

        System.out.println("After Dequeue:"+queue); // After Dequeue:Queue [elements=[Rafael, Novak]]

        System.out.println("Queue Size now:"+queue.size()); // Queue Size now:2
    }
}
