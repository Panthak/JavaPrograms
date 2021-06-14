import java.util.*;

class StackLinkedList {
    static class Node {
        int value = 0;
        Node rightPtr;
        Node(int value) {
            this.value = value;
            rightPtr = null;
        }
    }
    
    void pushElement(Node node, int value) {
        if(node.rightPtr != null) {
            pushElement(node.rightPtr, value);
        }
        else {
            node.rightPtr = new Node(value);
            System.out.println("Element "+value+" added to the right of "+node.value);
        }
    }

    void traverseLinkedList(Node node) {
        if(node != null) {
            System.out.print(node.value+" --> ");
            traverseLinkedList(node.rightPtr);
        }
    }

    void popElement(Node node) {
        if (node != null) {
            if (node.rightPtr.rightPtr == null) {
                //removing last element from the list.
                System.out.println("\nRemoved element : "+node.rightPtr.value);
                node.rightPtr = null;
            }
            else {
                popElement(node.rightPtr);
            }
        }
    }

    public static void main(String[] args) {
        StackLinkedList sll = new StackLinkedList();
        Node root = new Node(10);
        
        sll.pushElement(root, 20);
        sll.pushElement(root, 30);

        System.out.println("Created LinkedList : ");
        sll.traverseLinkedList(root);

        sll.popElement(root);
        sll.traverseLinkedList(root);

    }
}