import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = insert(node.rightChild, value);

        }
        return node;
    }

    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMin(root).value;
    }

    private Node findMin(Node node) {
        if (node.leftChild == null) {
            return node;
        }
        return findMin(node.leftChild);
    }

    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMax(root).value;
    }

    private Node findMax(Node node) {
        if (node.rightChild == null) {
            return node;
        }
        return findMax(node.rightChild);
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.leftChild) + countNodes(node.rightChild);
    }

    public boolean equals(BinarySearchTree other) {
        return equals(this.root, other.root);
    }

    private boolean equals(Node node1, Node node2) {

        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return (node1.value == node2.value) &&
                equals(node1.leftChild, node2.leftChild) &&
                equals(node1.rightChild, node2.rightChild);

    }

    public boolean find(int value) {
        return find(root, value);
    }

    private boolean find(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (node.value == value) {
            return true;
        }

        if (value < node.value) {
            return find(node.leftChild, value);
        }

        return find(node.rightChild, value);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.leftChild);
        System.out.print(node.value + " ");
        traverseInOrder(node.rightChild);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node node) {
        if (node == null) {
            return;
        }
        traversePostOrder(node.leftChild);
        traversePostOrder(node.rightChild);
        System.out.print(node.value + " ");
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root);
    }

    private boolean isBinarySearchTree(Node node) {
        if (node == null) {
            return true;
        }

        if (node.leftChild != null && findMax(node.leftChild).value > node.value) {
            return false;
        }
        if (node.rightChild != null && findMin(node.rightChild).value < node.value) {
            return false;
        }

        return isBinarySearchTree(node.leftChild) && isBinarySearchTree(node.rightChild);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        if (node.leftChild == null && node.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return node;
        }
        if (value < node.value) {
            node.leftChild = delete(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = delete(node.rightChild, value);
        } else {
            if (node.leftChild == null) {
                return node.rightChild;
            }
            if (node.rightChild == null) {
                return node.leftChild;
            }
            node.value = findMin(node.rightChild).value;
            node.rightChild = delete(node.rightChild, node.value);
        }

        return node;

    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.value + " ");

            if (currentNode.leftChild != null) {
                queue.add(currentNode.leftChild);
            }

            if (currentNode.rightChild != null) {
                queue.add(currentNode.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        //            7
        //          /   \
        //         5     9
        //        / \   / \
        //       2  6  8   10

        var tree = new BinarySearchTree();
        tree.insert(7);
        tree.insert(5);
        tree.insert(9);
        tree.insert(2);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println("Level Order Traversal");
        tree.traverseLevelOrder(); // 7 5 9 2 6 8 10
        System.out.println();
        System.out.println("Pre Order Traversal");
        tree.traversePreOrder(); // 7 5 2 6 9 8 10
        System.out.println();
        System.out.println("In Order Traversal");
        tree.traverseInOrder(); // 2 5 6 7 8 9 10
        System.out.println();
        System.out.println("Post Order Traversal");
        tree.traversePostOrder(); // 2 6 5 8 10 9 7
        System.out.println();

        System.out.println("Height: " + tree.height()); // 2
        System.out.println("Min: " + tree.findMin()); // 2
        System.out.println("Max: " + tree.findMax()); // 10
        System.out.println("Count: " + tree.countNodes()); // 7
        System.out.println("Is Binary Search Tree: " + tree.isBinarySearchTree()); // true
        System.out.println("Find 6: " + tree.find(6)); // true

        var tree2 = new BinarySearchTree();
        tree2.insert(7);
        tree2.insert(5);
        tree2.insert(9);

        System.out.println("Equals: " + tree.equals(tree2)); // false

    }
}
