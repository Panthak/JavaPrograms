import java.util.*;

class BinaryTree {
    static class Node {
        int value = 0;
        Node leftChild, rightChild;
        
        Node(int value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }
    }

    public void insertNode(Node node, int value) {
        if (value < node.value) {
            if(node.leftChild != null) {
                insertNode(node.leftChild, value);
            }
            else {
                node.leftChild = new Node(value);
                System.out.println("inserted "+value+" to the left of "+node.value);
            }
        }
        else if (value > node.value) {
            if(node.rightChild != null) {
                insertNode(node.rightChild, value);
            }
            else {
                node.rightChild = new Node(value);
                System.out.println("inserted "+value+" to the right of "+node.value);
            }
        }
    }
    

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(5);
        tree.insertNode(root,2);
        tree.insertNode(root,4);
        tree.insertNode(root,3);
        tree.insertNode(root,8);
        tree.insertNode(root,6);
        tree.insertNode(root,7);
        tree.insertNode(root,9);
        System.out.println("\n### In-order : ");
        tree.traverseInOrder(root);
        //System.out.println("is the tree full binary ? "+tree.isFullBinaryTree(root));
        System.out.println("\n### Pre-order : ");
        tree.traversePreOrder(root);
        System.out.println("\n### Post-order : ");
        tree.traversePostOrder(root);
    }

    //A full binary tree is a binary tree where every node has exactly 0 or 2 children.
    boolean isFullBinaryTree(Node node) {
        if (node == null) {
            return true;
        }

        if (node.leftChild == null && node.rightChild == null) {
            return true;
        }

        if ((node.leftChild != null) && (node.rightChild != null)) {
            return (isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild));
        }
        return false;
   }    

   void traverseInOrder(Node node) {
        if(node != null) {
            traverseInOrder(node.leftChild);
            System.out.print(node.value + "\t");
            traverseInOrder(node.rightChild);
        }
    }
   
   void traversePreOrder(Node node) {
       if (node != null) {
        System.out.print(node.value+"\t");
        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
       }
   }

   void traversePostOrder(Node node) {
    if (node != null) {
        traversePostOrder(node.leftChild);
        traversePostOrder(node.rightChild);
        System.out.print(node.value+"\t");
    }
}
}