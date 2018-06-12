package binTree;


import java.util.HashMap;

/**
 * author:Jan
 * this is Node
 * POJO
 */
class Node{
//    left Node
    private  Node leftChild;
//      right Node
    private Node rightChild;
//    data
    private  int data;
    Node(int data) {
        this.data = data;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

/**
 * binaryTree class
 */
class BinaryTree{
    HashMap
    public Node root;
    public static  int index;
//    创建二叉树
    public Node createBintree(int [] data) {
//        ?
       Node tmp = null;
        if (data[index] != '#'){
            tmp = new Node(data[index]);
            index++;
            tmp.setLeftChild(createBintree(data));
            index++;
            tmp.setRightChild(createBintree(data));
        }
        return tmp;
    }
    public void preOrder(Node root){
        if (null == root){
            return;
        }
            System.out.println(root.getData());
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
    }
}
public class BinTree {
    public static void main(String[] args) {
//                    1
//             2               5
//        3          4      #      6
//     #     #   #   #          #      #
        int [] data = {1,2,3,'#','#',4,'#','#',5,6,'#','#','#'};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = binaryTree.createBintree(data);
        binaryTree.preOrder(binaryTree.root);
    }
}
