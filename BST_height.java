import java.util.*;

public class BST_height {
    static class Node {
        int value;
        Node leftChild, rightChild;
        Node(int value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }
    }   
    
    private void insertNode(Node node, int value) {
        if (node != null) {
            if (value < node.value) {
                if (node.leftChild != null) {
                    insertNode(node.leftChild, value);
                }
                else {
                    node.leftChild = new Node(value);
                    System.out.println("Node "+value+" created as left child of "+node.value);
                }
            }
            else if (value > node.value) {
                if (node.rightChild != null) {
                    insertNode(node.rightChild, value);
                }
                else {
                    node.rightChild = new Node(value);
                    System.out.println("Node "+value+" created as right child of "+node.value);
                }
            }
        }
    }

    private void traverseTreeBFS(Node node) {
        //BFS traversal
        Node polledNode;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()) {
            polledNode = queue.poll();
            System.out.print(polledNode.value+" --> ");
            if (polledNode.leftChild != null) {
                queue.add(polledNode.leftChild);
            }
            if (polledNode.rightChild != null) {
                queue.add(polledNode.rightChild);
            }
        }
    }

    private int findHeight(Node node) {
        if (node == null) {
            return -1;
        }
        else {
            int leftSubTreeDepth = findHeight(node.leftChild);
            int rightSubTreeDepth = findHeight(node.rightChild);
            // System.out.println("Height at node : "+node.value+" --> "+(Math.max(leftSubTreeDepth, rightSubTreeDepth)+1));
            // System.out.println("Balance factor at node : "+node.value+" --> "+(leftSubTreeDepth - rightSubTreeDepth));
            return (Math.max(leftSubTreeDepth, rightSubTreeDepth)+1);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        BST_height ob = new BST_height();
        ob.insertNode(root, 8);
        ob.insertNode(root, 18);
        ob.insertNode(root, 5);
        ob.insertNode(root, 11);
        ob.insertNode(root, 17);
        ob.insertNode(root, 4);
        System.out.println("### BFS traversal : \n");
        ob.traverseTreeBFS(root);
        System.out.println("\n### Height of the tree : "+ob.findHeight(root));
    }
}
