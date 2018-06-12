package binTree;


import com.sun.deploy.panel.ITreeNode;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
//    前序
    public void preOrder(Node root){
        if (null == root){
            return;
        }
            System.out.print(root.getData() +",");
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
    }
//    中序
    public void midOrder(Node root){
        if (null == root){
            return;
        }
        midOrder(root.getLeftChild());
        System.out.print(root.getData()+",");
        midOrder(root.getRightChild());
    }
//    后续
    public void aftOrder(Node root){
        if (null == root){
            return;
        }
        aftOrder(root.getLeftChild());
        aftOrder(root.getRightChild());
        System.out.print(root.getData()+",");
    }
//    取高度
    public int getHeight(Node root){
        Node tmp = root;
        int height = 0;
        while (null !=tmp){
            tmp = tmp.getLeftChild();
            height++;
        }
        return height;
    }
//    求叶子数
    public int getLeaf(Node root){
        if (null == root){
            return 0;
        }
        else if (null == root.getLeftChild() && null == root.getRightChild()){
            System.out.println("I am leaf:"+root.getData());
            return 1;
        }
        int tmp =  getLeaf(root.getLeftChild()) +getLeaf(root.getRightChild());
        return  tmp;
    }
//    获得K层节点数,假设从1层开始
    public int getNodeOfK(Node root,int k){
       if (1 == k){
           if (null == root){
               return 0;
           }
           return 1;
       }
       return getNodeOfK(root.getLeftChild(),k-1)+getNodeOfK(root.getRightChild(),k-1);
    }
//    找节点
    public Node findNode(Node root,int x){
        if (null == root){
            return null;
        }
        else if (root.getData() == x){
            return root;
        }
        Node left = findNode(root.getLeftChild(), x);
        if (null != left){
            return left;
        }
        Node right = findNode(root.getRightChild(), x);
        if (null != right){
            return right;
        }
        return null;
    }
//    找父节点
    public Node findParentNode(Node root,int x){
        if(null == root){
            return null;
        }
//        创建临时左右孩子
        Node childLeft = root.getLeftChild();
        Node chileRight = root.getRightChild();
        // 找孩子
        if (null != childLeft && x == childLeft.getData()){
            return root;
        }
        if (null != chileRight && x ==chileRight.getData()){
            return root;
        }
//        把爸爸送回来
        Node parentLeft = findParentNode(root.getLeftChild(),x);
        if (null != parentLeft){
            return parentLeft;
        }
        Node parentRight = findParentNode(root.getRightChild(),x);
        if (null != parentRight){
            return  parentRight;
        }
        return null;
    }
    public void levelOrder(Node root){
        Node tmp = root;
        Queue <Node> queue = new LinkedList<>();
        LinkedList<Node> list = new LinkedList<>();
//         跟add类似，队列满的时候，add抛异常，offer返回false
        queue.offer(root);
        while (! queue.isEmpty()){
//          删除并返回队首
            Node pre = queue.poll();
//          全放进链表里存着
            list.add(pre);
            if (pre.getLeftChild() != null){
                queue.offer(pre.getLeftChild());
            }
            if (pre.getRightChild() != null){
                queue.offer(pre.getRightChild());
            }
        }
        Iterator<Node> iterator = list.iterator();
        while (iterator.hasNext()){
            Node t = (Node)iterator.next();
            System.out.print(t.getData() +",");
        }
//        iter
//        itar
    }
    public  boolean isCompleteBinTree(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (null == tmp) {
                break;
            }
            queue.offer(tmp.getLeftChild());
            queue.offer(tmp.getRightChild());
        }
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if (null != tmp){
                return false;
            }
        }
        return true;
    }

}
public class BinTree {
    public static void main(String[] args) {
//                    1
//             2               5
//        3          4      #      6
//     #     #      #   #      #      #
//        int [] data = {1,2,3,'#','#',4,'#','#',5,6,'#','#','#'};
        int [] data = {1,2,3,'#','#',4,'#','#',5,6,'#','#',7,'#','#'};
        BinaryTree binaryTree = new BinaryTree();
//        获取树
        binaryTree.root = binaryTree.createBintree(data);
//        测前序
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
//        测中序
        binaryTree.midOrder(binaryTree.root);
        System.out.println();
//        测后续
        binaryTree.aftOrder(binaryTree.root);
        System.out.println();
//        树的高度
        System.out.println(binaryTree.getHeight(binaryTree.root));
//       测叶子数
        System.out.println(binaryTree.getLeaf(binaryTree.root));
//       测k层节点数
        System.out.println(binaryTree.getNodeOfK(binaryTree.root,3));
//        找节点
        System.out.println(binaryTree.findNode(binaryTree.root,5));
//        找爸爸节点
        System.out.println(binaryTree.findParentNode(binaryTree.root,5).getData());
//         层序遍历
        binaryTree.levelOrder(binaryTree.root);
        System.out.println();
//        是不是完全二叉树
        System.out.println(binaryTree.isCompleteBinTree(binaryTree.root));
    }
}
