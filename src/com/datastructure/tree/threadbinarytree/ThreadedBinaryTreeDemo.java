package com.datastructure.tree.threadbinarytree;

/**
 * @author Hacah
 * @date 2021/1/2 21:04
 * @Description 实现二叉树的中序线索化二叉树的方法
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree(1, "1");
        ThreadedBinaryTree.Node threeNode = binaryTree.addLeftChild(3, "3");
        threeNode.addLeftChild(8, "8");
        ThreadedBinaryTree.Node node10 = threeNode.addRightChild(10, "10");
        binaryTree.addRightChild(6, "6").addLeftChild(14, "14");


        // 测试中序线索化二叉树
        binaryTree.threadedNode();
        // 查看node10左节点是否3，右节点是否是1
        System.out.println(node10.getLeftChild());
        System.out.println(node10.getRightChild());
        System.out.println();

        // 测试遍历线索化二叉树
        binaryTree.threadedList();

    }


}

/**
 * 二叉树的类
 */
class ThreadedBinaryTree {

    /** 根节点 */
    private Node root;

    /** 保存前驱一个节点 */
    private static Node pre;

    public ThreadedBinaryTree(int no, String name) {
        root = new Node(no, name);
    }

    /**
     * 重载方法
     */
    public void threadedNode() {
        threadedNode(root);
    }

    /**
     * 遍历中序线索化二叉树
     * 非递归方式
     */
    public void threadedList() {
        Node temp = root;
        while (temp != null) {
            // 走到中序遍历的第一个的节点，首位节点的特点是leftChildState = 1
            while (temp.leftChildState != 1) {
                temp = temp.leftChild;
            }
            // 输出该节点
            System.out.println(temp);

            // 如果右节点都是后序节点就输出显示
            while (temp.rightChildState == 1) {
                temp = temp.rightChild;
                System.out.println(temp);
            }

            // 向右节点走
            temp = temp.rightChild;

        }
    }

    /**
     * 中序线索化二叉树
     *
     * @param node
     */
    public void threadedNode(Node node) {
        // node为空就不能线索化
        if (node == null) {
            return;
        }

        // 1.线索化左子树
        threadedNode(node.leftChild);
        // 2.线索化本节点

        if (node.leftChild == null) {
            // 左节点指向前驱节点
            node.leftChild = pre;
            // 设置状态为指向前驱节点
            node.leftChildState = 1;
        }
        // 使用pre前节来操作右节点的线索化
        if (pre != null && pre.rightChild == null) {
            pre.rightChild = node;
            pre.rightChildState = 1;
        }
        // 当前值赋值给前节点，代表跟在node的后面
        pre = node;

        // 3.线索化右子树
        threadedNode(node.rightChild);

    }

    /**
     * 添加左节点
     *
     * @return
     */
    public Node addLeftChild(int no, String name) {
        return root.addLeftChild(no, name);
    }

    /**
     * 添加右节点
     *
     * @return
     */
    public Node addRightChild(int no, String name) {
        return root.addRightChild(no, name);
    }


    /**
     * 二叉树的节点
     */
    static class Node {

        private int no;
        private String name;
        private Node leftChild;
        private Node rightChild;

        /** 用变量表示左指针指向的是哪个节点，如果是0为左节点，1为前序节点 */
        private int leftChildState;
        /** 用变量表示右指针指向的是哪个节点，如果是0为右节点，1为后序节点 */
        private int rightChildState;

        public Node(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        /**
         * 添加左节点
         *
         * @return
         */
        public Node addLeftChild(int no, String name) {
            Node node = new Node(no, name);
            this.leftChild = node;
            return node;
        }

        /**
         * 添加右节点
         *
         * @return
         */
        public Node addRightChild(int no, String name) {
            Node node = new Node(no, name);
            rightChild = node;
            return node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

    }

}

