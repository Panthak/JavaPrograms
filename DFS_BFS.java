import java.util.*;

class DFS_BFS {
    
    static Queue<Node> queue = new LinkedList<>();
    static boolean isElementFound = false;
    static class Node {
        int value;
        Node leftChild, rightChild;

        Node(int value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }
    }

    void insertNode(Node node, int value) {
        if (value <= node.value) {
            if (node.leftChild != null) {
                insertNode(node.leftChild, value);
            }
            else {
                node.leftChild = new Node(value);
                System.out.println("Node "+value+" create to the left of "+node.value);
            }
            
        }
        else {
            if (node.rightChild != null) {
                insertNode(node.rightChild, value);
            }
            else {
                node.rightChild = new Node(value);
                System.out.println("Node "+value+" create to the right of "+node.value);
            }
        }
    }

    void traverseDFS(Node node) {
        if (node != null) {
            traverseDFS(node.leftChild);
            System.out.print(node.value+"\t");
            traverseDFS(node.rightChild);
        }
    }

    void isElementPresent(Node node, int search) {
        if (node != null) {
            //if search value is less then the node, traverse left subtree.
            if (node.value > search) {
                isElementPresent(node.leftChild, search);
            }
            //if search value is greater then the node, traverse right subtree.
            else if (node.value < search) {
                isElementPresent(node.rightChild, search);
            }
            else if (node.value == search) {
                System.out.println("\n\n"+search+" is present in the tree !");
                isElementFound = true;
            }
        }
        if (!isElementFound)
            System.out.println("\n\n"+search+" not found in the tree !");
    }

    
    void traverseBFS(Node node) {
        queue.add(node);
        Node polledNode;
        while(!queue.isEmpty()) {
            polledNode = queue.poll();
            System.out.print(polledNode.value+"\t");
            if (polledNode.leftChild != null) {
                queue.add(polledNode.leftChild);
            }
            if (polledNode.rightChild != null) {
                queue.add(polledNode.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        DFS_BFS ob = new DFS_BFS();
        Node root = new Node(27);
        ob.insertNode(root, 14);
        ob.insertNode(root, 35);
        ob.insertNode(root, 10);
        ob.insertNode(root, 19);
        ob.insertNode(root, 31);
        ob.insertNode(root, 42);
        System.out.println("### In-order traversal : ");
        ob.traverseDFS(root);
        System.out.println("\n\n### BFS traversal : ");
        ob.traverseBFS(root);
        ob.isElementPresent(root, 352);
    }
}