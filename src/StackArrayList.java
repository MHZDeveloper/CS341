import java.util.ArrayList;
import java.util.List;

public class StackArrayList {

    private List<String> elements = new ArrayList<>();


    public void push(String element) {
        elements.add(element);
    }

    public String toString() {
        return "Stack [elements=" + elements + "]";
    }

    public int size() {
        return elements.size();
    }

    public String peek() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(elements.size() - 1);
    }


    public String pop() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        String top = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return top;
    }



    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public static void main(String[] args) {
        StackArrayList stack = new StackArrayList();
        System.out.println("Is Stack Empty:"+stack.isEmpty()); // Is Stack Empty:true
        stack.push("Roger");
        stack.push("Rafael");
        stack.push("Novak");
        System.out.println("Is Stack Empty:"+stack.isEmpty()); // Is Stack Empty:false
        System.out.println(stack); // Stack [elements=[Roger, Rafael, Novak]]
        System.out.println("Stack Size:"+stack.size()); // Stack Size:3
        System.out.println("Peek Top Element:"+stack.peek()); // Peek Top Element:Novak
        System.out.println("After peek:"+stack); // After peek:Stack [elements=[Roger, Rafael, Novak]]
        System.out.println("Pop Top Element:"+stack.pop()); // Pop Top Element:Novak
        System.out.println("After pop:"+stack); // After pop:Stack [elements=[Roger, Rafael]]
        System.out.println("Stack Size now:"+stack.size()); // Stack Size now:2
    }
}
