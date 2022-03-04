import java.util.*;

public class DoublyLinkedList {
    static Node root = new Node(0);
    static Node tail = new Node(0);
    static class Node {
        int value = 0;
        Node rightPtr, leftPtr;
        public Node(int value) {
            this.value = value;
            rightPtr = null;
            leftPtr = null;
        }
    }

    public void insertNodeAtLast(Node node, int value) {
        if (node != null) {
            if(node.rightPtr != tail) {
                insertNodeAtLast(node.rightPtr, value);
            }
            else {
                //inserting a node to the right most end
                node.rightPtr = new Node(value);
                //setting left pointer of the new node to the previous node
                node.rightPtr.leftPtr = node;
                node.rightPtr.rightPtr = tail;
                tail.leftPtr = node.rightPtr;
                System.out.println("Inserted : "+value);
                System.out.println("Left pointer set to : "+node.rightPtr.leftPtr.value);
            }
        }
    }

    public void insertNodeAtBegin(int value) {
        //creating a new node and setting it in-between of the root and first node
        Node newNode = new Node(value);
        newNode.rightPtr = root.rightPtr;
        newNode.leftPtr = root;
        root.rightPtr = newNode;
    }

    public void insertNodeInBetween(Node node,int value, int a, int b) {
        if (node != null) {
            while(node.rightPtr != tail) {
                if (node.value == a && node.rightPtr.value == b) {
                    Node newNode = new Node(value);
                    newNode.rightPtr = node.rightPtr;
                    newNode.leftPtr = node;
                    node.rightPtr.leftPtr = newNode;
                    node.rightPtr = newNode;
                    break;
                }
                node = node.rightPtr;
            }
        }
    }

    public void removeNode(Node node, int value) {
        boolean isElementPresent = false;
        if (node != null) {
            while(node != tail) {
                if (node.value == value) {
                    node.leftPtr.rightPtr = node.rightPtr;
                    node.rightPtr.leftPtr = node.leftPtr;
                    System.out.print("Removed : " + value+"\n");
                    isElementPresent = true;
                    break;
                }
                node = node.rightPtr;
            }
            if (!isElementPresent)
                System.out.print("Node " + value+" not found in the list\n");
        }
    }

    public void traverseLinkedList(Node node) {
        if (node != null && node.rightPtr != tail) {
            System.out.print(node.rightPtr.value + " <--> ");
            traverseLinkedList(node.rightPtr);
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        root.rightPtr = tail;
        tail.leftPtr = root;
        dll.insertNodeAtLast(root, 20);
        dll.insertNodeAtLast(root, 30);
        dll.insertNodeAtLast(root, 40);
        dll.insertNodeAtLast(root, 50);
        dll.insertNodeAtBegin(10);
        dll.insertNodeInBetween(root, 34, 30, 40);
        dll.removeNode(root, 300);
        dll.traverseLinkedList(root);
    }

}
