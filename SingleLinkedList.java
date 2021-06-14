import java.util.*;

class SingleLinkedList {
    static class Node {
        int value = 0;
        Node rightPtr;
        Node(int value) {
            this.value = value;
            rightPtr = null;
        }
    }
    
    void insertElement(Node node, int value) {
        if(node.rightPtr != null) {
            insertElement(node.rightPtr, value);
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

    void removeElement(Node node, int value) {
        if (node != null) {
            if(node.rightPtr.value != value) {
                removeElement(node.rightPtr, value);    
            }
            else if (node.rightPtr.rightPtr == null) {
                //removing last element from the list.
                System.out.println("\nRemoved element : "+node.rightPtr.value);
                node.rightPtr = null;
            }
            else {
                System.out.println("\nRemoved element : "+node.rightPtr.value);
                node.rightPtr = node.rightPtr.rightPtr;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        Node root = new Node(10);
        
        sll.insertElement(root, 20);
        sll.insertElement(root, 30);

        System.out.println("Created LinkedList : ");
        sll.traverseLinkedList(root);

        sll.removeElement(root, 30);
        sll.traverseLinkedList(root);

    }
}